# SCOTTConsumer

Receive SMOOL messages from producer gateways. If OK, send id to local client by using TCP socket. 

## Installation and configuration

This app should be installed typically on a raspberry PI 3 acting as edge gateway 

To simplify installation but allow to hot reconfiguration of the KP once it is deployed (since this KP is going to be in PRODUCTION mode the first time in SCOTT so it will be some modifications after deployment on rail station):
- install java 8 o upper
- change config in java classes and compile
- run as java app

```sh
cd ~/runtime-smool/SCOTTConsumer

javac -d bin -cp bin:lib/* src/SCOTTConsumer/logic/ConsumerMain.java

java -cp bin:lib/* SCOTTConsumer.logic.ConsumerMain
```