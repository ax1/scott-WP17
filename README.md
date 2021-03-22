# SCOTT HARVESTER INFRASTRUCTURE

>Note: this is only a summary. Go to each README.md inside every project for detailed usage.

This repository is related to the [SCOTT project](https://scottproject.eu/) (EU H2020), addressing the Use Case (in Work Package 17) [Safe freight and traffic management in intermodal logistic hubs](https://scottproject.eu/uc11-safe-freight-and-traffic-management-in-intermodal-logistic-hubs/).

## How it works

Some low-power devices (harvesters), attached to train wagons or important goods, provide `alive` signals (see [Autonomy of devices / energy efficiency of WSN](https://scottproject.eu/autonomy-of-devices-energy-efficiency-of-wsn/) ). These signals are received by gateways covering different areas of a train shunting yard (project `scott-serial`). To provide interoperability among gateways from different vendors, the open-source [SOFIA - SMOOL IoT middleware](https://bitbucket.org/jasonjxm/smool/) is used. The project `SCOTTProducer` transforms the harvester info into a semantic message and sends it to an SMOOL server located in the internal network of the shunting yard. These messages are received automatically by the `SCOTTConsumer`. The content is then extracted and delivered to the `scott-mqtt` project, which assembles the ad-hoc message for usage in CMW brokers. Finally, these brokers deliver the message to the SCOTT SFTM controlling the management of goods to be delivered. 

The main higlights are:
- the harvesters (not provided in this repo) are low-cost, zero maintenance, auto gathering energy from different sources. 
- the SMOOL components provide an interoperability layer between different gateways, and also between different control centers.

The real demonstration was taken in February 2020. It was composed of 4 harvesters located in 2 different areas (covered by 2 gateways), and 1 SMOOL server (request Deliverable D17.5 to the SCOTT consortium for more details).

## Installation

- **harvesters**: hardware components. See harvester project for config and install.
- **SMOOL server**: download from bitbucket and configure the real server ip in the config file. Make a daemon and start
- **scott-serial**: start as node app in gateway1
- **SCOTTProducer**: start as node app in gateway1
- **SCOTTConsumer**: start as node app in gateway2
- **scott-mqtt**: configure .env with real mqtt user/pw and start as node app in gateway2

## Workflow

1. (GW1) harvester->scott-serial
2. (GW1) scott-serial->SCOTTProducer
3. (GW2) SMOOL message arriving to SIB->sent to all subscribers
4. (GW2) SCOTTConsumer->scott-mqtt
5. (GW2) scott-mqtt->INDRA CMW->TECNALIA SFTM



