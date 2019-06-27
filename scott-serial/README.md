# SCOTT-SERIAL

Get data from a 433MHz radio device and return the id of the harvester sending the signal.

This code ins itended to run on raspberry PI3

# Important data

- on raspi, the default TX/RX for serial are the 8/10 pins
- to read serial use command `sudo minicom -b 9600 -o -/dev/serial0` (o /dev/ttyS0 )  

## Background

Trying to get direct radio bytes to serial pins, some problems:
- must configure the serial. raspi-serial was used but no good results because it is just a serial and no modulation
- 433 modulation libraries for 433-ASK modulation are not so good (try other 433 techniques later)
- the bluetooth uses the uart serail so it must be disable. See npm raspi-serial.

**So first decision is to add an intermediate chip to get the radio/demodulate and then pass a clean id to the serial gpio pins**

Then the ASK modulation was really fine with arduinos nanos `radioHead`library. Range up to 200 m well tested and by changing the hardware to work full power with 5v.

The problem is that attiny85 did not work sending data with the radiohead lib. So manchester library was used instead BUT the range was reduced drastically on high noise environments.

## Usage

- use arduino nano as receiver and connect radio
- upload the custom sketch for scott
- test serial monitor receiving data
- prepare to raspberry, make a resistor divider to shift from 5V to 3V3
- connect arduino tx to resistor and 3v3 pin in resistor to pin 10 in raspi
- test receiving with minicom
- install scott-serial (this app)