#include <SoftwareSerial.h>
SoftwareSerial SerialESP8266(3, 2); // RX | TX

String ssid = "Movistar_15609585"; //  your network SSID (name)
String pass = "00940375259";    // your network password (use for WPA, or use as key for WEP)

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
  SerialESP8266.println("AT+CIFSR");

  //------fin de configuracion-------------------

  delay(1000);
  pinMode(13, OUTPUT);
}

int numSaltos = 0;
String msg = "";
bool repe = false;

void loop() {

  if (SerialESP8266.available()) {
    char c = SerialESP8266.read();
    if (c == '\n') {
      numSaltos += 1;
    }
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

      if (msg.substring(0, 2) == "+I") {
        String temp = msg.substring(msg.indexOf('p') + 1 , msg.indexOf('H') - 1);

        String xval = getValue(temp, '=', 0);
        String yval = getValue(temp, '=', 1);

        Serial.println("pin:" + xval);
        Serial.println("on:" + yval);

        int pin = getValue(temp, '=', 0).toInt();
        int on = getValue(temp, '=', 1).toInt();

        pinMode(pin, OUTPUT);
        digitalWrite(pin, on);
      }

      msg = "";
    }
  }

  if (Serial.available())
  { char c = Serial.read();
    SerialESP8266.print(c);
  }


}


String getValue(String data, char separator, int index)
{
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
