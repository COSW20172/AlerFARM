#include <WiFiEsp.h>
#include <WiFiEspClient.h>
#include <WiFiEspServer.h>
#include <WiFiEspUdp.h>
#include <DHT.h>
#include <SoftwareSerial.h>

WiFiEspClient client;  //Iniciar el objeto para cliente 
SoftwareSerial SerialESP8266(3, 2); // RX | TX

#define DHTPIN 6//Defiene el pin al que se conectará el sensor
#define DHTTYPE DHT11//Seleciona el tipo de sensor

DHT dht(DHTPIN, DHTTYPE);//Configura la librería

float temperature = 0;//Declara la variable temperatura
float humedity = 0;//Declara la variable humedad

const char* ssid     = "Redprivada";
const char* password = "r3dpr1v4d4";

const char* host = "alertfarm.000webhostapp.com";
const int httpPort = 80;

const String idCliente = "1013622878";
const String idArduino = "1";

void setup()
{
  Serial.begin(9600);
  SerialESP8266.begin(9600);

  WiFi.init(&SerialESP8266);
  // We start by connecting to a WiFi network

  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  Serial.println(WiFi.status());
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
    WiFi.begin(ssid, password);
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void loop()
{
  int err;
  humedity = dht.readHumidity();// Lee la humedad
  temperature = dht.readTemperature();//Lee la temperatura
  if ( humedity != 0 && temperature != 0 )
  {
    Serial.print("Temperatura: ");
    Serial.print(temperature);
    Serial.print(" Humedad: ");
    Serial.print(humedity);
    Serial.println();
  }
  else
  {
    Serial.println();
    Serial.print("Error Num :");
    Serial.print(err);
    Serial.println();
  }
  connectionHost();
  addHumedity(humedity);
  connectionHost();
  addTemperature(temperature);
  
  delay(60000);
}

void connectionHost(){
  Serial.print("connecting to ");
  Serial.println(host);

  // Use WiFiClient class to create TCP connections

  if (!client.connect(host, httpPort)) {
    Serial.println("connection failed");
    return;
  }
}

void sendUrl(String url){
  Serial.println(url);

  // This will send the request to the server
  client.print(String("GET ") + url + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" +
               "Connection: close\r\n\r\n");
  unsigned long timeout = millis();
  while (client.available() == 0) {
    if (millis() - timeout > 5000) {
      Serial.println(">>> Client Timeout !");
      client.stop();
      return;
    }
  }

  // Read all the lines of the reply from server and print them to Serial
  while (client.available()) {
    String line = client.readStringUntil('\r');
    Serial.print(line);
  }

  Serial.println();
  Serial.println("closing connection");
}

// We now create a URL for the request
String url;
  
void addHumedity(float value){
  
  Serial.print("Requesting URL: ");

  url = "/AlertFarm/setHumedad.php?idArduino="+ idArduino +"&valor=" + String(value) + "&idClientes=" + idCliente;
  
  sendUrl(url);
}

void addTemperature(float value){
  
  Serial.print("Requesting URL: ");

  url = "/AlertFarm/setTemperatura.php?idArduino="+ idArduino +"&valor=" + String(value) + "&idClientes=" + idCliente;
  
  sendUrl(url);
}
