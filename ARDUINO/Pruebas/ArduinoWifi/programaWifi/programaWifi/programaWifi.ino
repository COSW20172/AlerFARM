#include <SoftwareSerial.h>
SoftwareSerial SerialESP8266(3, 2); // RX | TX

String ssid = "Redprivada"; //  your network SSID (name)
String pass = "r3dpr1v4d4";    // your network password (use for WPA, or use as key for WEP)

void setup() {
  Serial.begin(9600);
  SerialESP8266.begin(9600);

  //Verificamos si el ESP8266 responde
  SerialESP8266.println("AT");
  if (SerialESP8266.find("OK"))
    Serial.println("Respuesta AT correcto");
  else
    Serial.println("Error en ESP8266");

  //-----Configuración de red-------//Podemos comentar si el ESP ya está configurado

  //ESP8266 en modo estación (nos conectaremos a una red existente)
  SerialESP8266.println("AT+CWMODE=1");
  if (SerialESP8266.find("OK"))
    Serial.println("ESP8266 en modo Estacion");

  //Nos conectamos a una red wifi
  String SSIDConnection = ("AT+CWJAP=") + ('"' + ssid + '"' + ',' + '"' + pass + '"');
  SerialESP8266.println(SSIDConnection);
  Serial.println("Conectandose a la red ...");
  SerialESP8266.setTimeout(10000); //Aumentar si demora la conexion
  if (SerialESP8266.find("OK"))
    Serial.println("WIFI conectado");
  else
    Serial.println("Error al conectarse en la red");
  SerialESP8266.setTimeout(2000);
  //Desabilitamos las conexiones multiples
  SerialESP8266.println("AT+CIPMUX=1");
  if (SerialESP8266.find("OK"))
    Serial.println("Multiconexiones habilitadas");

  SerialESP8266.println("AT+CIPSERVER=1,80");
  if (SerialESP8266.find("OK"))
    Serial.println("Servidor establecido");

  printString("AT+CIFSR");

  //------fin de configuracion-------------------

  delay(1000);
  pinMode(13, OUTPUT);
}


String msg = "";

void loop() {

  if (SerialESP8266.available()) {
    char c = SerialESP8266.read();
    if (c == '+') {
      msg = msg + c;
      bool ban = true;
      while (ban) {
        c = SerialESP8266.read();
        msg = msg + c;
        if (c == '\n') {
          ban = false;
        }
      }

      if (msg.substring(0, 2) == "+I") { // filtro para que solo se vea pin y on
        String temp = msg.substring(msg.indexOf('p') + 1 , msg.indexOf('H') - 1);

        // split del areglo de caracteres por el = que se envia en el codigo html
        String xval = getValue(temp, '=', 0);
        String yval = getValue(temp, '=', 1);

        // mjestra en consola los valores recibidos
        Serial.println("pin:" + xval);
        Serial.println("on:" + yval);

        // transforma a enteros para envia la operación a los pines del arduino
        int pin = getValue(temp, '=', 0).toInt();
        int on = getValue(temp, '=', 1).toInt();

        // salida al arduino.
        pinMode(pin, OUTPUT);
        digitalWrite(pin, on);
      }
      msg = "";
    }
  }

  if (Serial.available()) {
    char c = Serial.read();
    SerialESP8266.print(c);
  }
}

/**
 * Función equivalen a split en java
 */
String getValue(String data, char separator, int index) {
  int found = 0;
  int strIndex[] = { 0, -1 };
  int maxIndex = data.length() - 1;

  for (int i = 0; i <= maxIndex && found <= index; i++) {
    if (data.charAt(i) == separator || i == maxIndex) {
      found++;
      strIndex[0] = strIndex[1] + 1;
      strIndex[1] = (i == maxIndex) ? i + 1 : i;
    }
  }
  return found > index ? data.substring(strIndex[0], strIndex[1]) : "";
}

/**
 * Muestra la direccion IP en consola
 */
void printString(String s) {
  int cont = 0; // contador de saltos 
  int cont2 = 0; // contador del sub string
  String mgs2 = ""; // buffer
  SerialESP8266.println(s); // envio del comando al serial del wifi
  if (SerialESP8266.available()) {
    bool ban = true;
    int contletras = 0; // contador de letras para el substring
    while (ban) {
      char c = SerialESP8266.read();
      mgs2 = mgs2 + c; // adicionar al buffer
      contletras += 1;
      if (c == '\n') {
        cont += 1;
      }
      // establece en que parte del string tiene que dividir
      if (c == ','){
        cont2 = contletras;
      }
      // condicional de salida del ciclo
      if (cont == 3) {
        ban = false;
      }
    }
    // muestra la direccion ip en consola
    Serial.print("IP: ");
    Serial.println(mgs2.substring(cont2));
  }
}
