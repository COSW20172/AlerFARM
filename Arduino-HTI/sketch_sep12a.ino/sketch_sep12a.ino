/*
   Creado: Joseph N. Arboleda Diaz
*/
#include <DHT.h>
//Defiene el pin al que se conectará el sensor
#define DHTPIN 6
//Seleciona el tipo de sensor
#define DHTTYPE DHT11

//Configura la librería
DHT dht(DHTPIN, DHTTYPE);
//Declara la variable temperatura
int temperatura = 0;
//Declara la variable humedad
int humedad = 0;
// Declarar la variable calor
int calor = 0; 

void setup() {
  //Inicializa el puerto serie
  Serial.begin(9600);
  //Inicializa la libreria dht
  dht.begin();
}
void loop() {

// Lee la humedad
  humedad = dht.readHumidity();
  //Lee la temperatura
  temperatura = dht.readTemperature();
  //calcula el indice de calor con base en las variables H Y T
  calor = dht.computeHeatIndex(temperatura, humedad, false);

  Serial.print("Humedad: "); //Imprime "Humedad: "
  Serial.print(humedad);//Imprime el valor de la humedad.
  Serial.println("%");//Imprime "%"
  Serial.print("Temperatura: ");//Imprime " Temperatura: "
  Serial.print(temperatura);//Imprime el valor de la temperatura
  Serial.println("C");//Imprime "C"
  Serial.print("Indice de calor: ");//Imprime "indice de calor: "
  Serial.print(calor);//Imprime el valor de la calor.
  Serial.println("%");//Imprime "%"

  //Espera 2 segundos para hacer la siguiente medida.
  delay (2000);

}
