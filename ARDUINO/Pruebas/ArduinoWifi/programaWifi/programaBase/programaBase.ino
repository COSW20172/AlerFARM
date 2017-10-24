#include <SoftwareSerial.h>
SoftwareSerial SerialESP8266(3, 2); // RX | TX

void setup() {
  Serial.begin(9600);
  SerialESP8266.begin(9600);

}

void loop() {
  if (SerialESP8266.available())
  { char c = SerialESP8266.read();
    Serial.print(c);
  }

  if (Serial.available())
  { char c = Serial.read();
    SerialESP8266.print(c);
  }

}
