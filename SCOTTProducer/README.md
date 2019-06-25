# SCOTTProducer

System gathering data from external wireless sensor networks and send the information in SMOOL ontology format

## Installation and configuration

This app should be installed typically on a raspberry PI 3 acting as edge gateway 

To simplify installation but allow to hot reconfiguration of the KP once it is deployed (since this KP is going to be in PRODUCTION mode the first time in SCOTT so it will be some modifications after deployment on rail station):
- install java 8 o upper
- change config in java classes and compile
- run as java app

```sh
cd ~/runtime-smool/SCOTTProducer

javac -d bin -cp bin:lib/* src/SCOTTProducer/logic/ProducerMain.java

java -cp bin:lib/* SCOTTProducer.logic.ProducerMain
```