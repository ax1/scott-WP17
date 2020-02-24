# SCOTT-MQTT

Send data from SMOOL consumers receiving harvester data, to the SFTM services, by using INDRA's CMW MQTT broker.

## Pre-requisites

**Change user and password with the ones in the .env file.** For security reasons this file is not commited.

To test by using mosquitto client (change to real user, password values):

```sh
nmap -Pn cmw.ext.innovarail.indra.es -p 8883

mosquitto_sub -h cmw.ext.innovarail.indra.es -p 8883 --cafile "/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/Public-ca-chain.cert.pem"  --insecure -u $USER -P $PASSWORD -t "131/100/+/+/110/100/#"

mosquitto_pub -h cmw.ext.innovarail.indra.es -p 8883 --cafile "/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/Public-ca-chain.cert.pem" --insecure -u $USER -P $PASSWORD -t "131/100/pp/pp/pp/pp/100/pp" -m "aaaee" //ALSO SEND STATUS 100 but in the subscriber, the topic status to receive messages is 101 because the broker will resend the message with that topic
```

## Usage

1- TCP socket receiving data from SMOOL consumer
2- a MQTT message is sent to broker


## Run options

1- `node index` start a socket and wait for harvester data before sending mqtt
2- `node index $harvesterID` (useful on tests) start the socket but send a message inmediately

## Tips

to get the public address of the device, use `curl ifconfig.me`