# SCOTT-MQTT

Send data from SMOOL consumers receiving harvester data, to the SFTM services, by using INDRA's CMW MQTT broker.

## Pre-requisites

**Change user and password with the ones in the .env file.** For security reasons this file is not commited.

To test by using mosquitto client (change to real user, password values):

```sh
nmap -Pn cmw.ext.innovarail.indra.es -p 8883

mosquitto_sub -h cmw.ext.innovarail.indra.es -p 8883 --cafile "/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/extca-chain.cert.pem"  --insecure -u $USER -P $PASSWORD -t "131/100/+/+/110/110/#"

mosquitto_pub -h cmw.ext.innovarail.indra.es -p 8883 --cafile "/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/extca-chain.cert.pem" --insecure -u $USER -P $PASSWORD -t "131/100/pp/pp/pp/pp/101/pp" -m "aaaee" //ALSO SEND STATUS 100 but in the subscriber, the topic status to receive messages is 101 because the broker will resend the message with that topic
```

## Usage

1- TCP socket receiving data from SMOOL consumer
2- a MQTT message is sent to broker