const mqtt = require('mqtt')

const connectOptions = {
  host: "cmw.ext.innovarail.indra.es",
  port: 8883,
  protocol: "mqtts",
  keepalive: 10,
  clean: true,
  reconnectPeriod: 2000,
  connectTimeout: 2000,
  /*
  key: fs.readFileSync("/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/private key/yard_planner.key.pem"),
  cert: fs.readFileSync("/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/yard_planner.cert.pem"),
  */
  //ca: fs.readFileSync("/home/ubuntu/SOFTWARE/SCOTT/INTERCAMBIO INDRA/ACCESO SERVIDOR MQTT/SCOTT__WP17-Integration_Lab/TECNALIA/public key/extca-chain.cert.pem"),
  username: process.env.MQTT_USER,
  password: process.env.MQTT_PASSWORD,
  rejectUnauthorized: false
}



var payload = `
{
  "ServiceID": 131100,
  "Root": {
    "Gateway": 0,
    "Source": 0
  },
  "Nodes": [
    {
      "Safety": false,
      "NodeID": 187221,
      "TimeStamp": 1555055619267,
      "TimeAccuracy": 1000000000,
      "Sensors-Actuators": [
        {
          "SensorID": 3336,
          "TimeStamp": 1555055619267,
          "TimeAccuracy": 1000000000,
          "Resources": {
            "5750": "CONTAINER_A282X12",
            "5513": "43.295242",
            "5514": "-2.891246",
            "5515":"0",
            "5516":"100"
          }
        }
      ],
      "CRC": 12237466
    }
  ],
  "CRC": 24495477
}
`

function send() {
  const client = mqtt.connect(connectOptions)
  client.on('connect', () => {
    console.log('connected to mqtt server')
    //SERVICE/SUBSERVICE/REGION/SUBREGION/ SOURCE/SUBSOURCE/STATUS/CRCHead/CRCPay
    client.publish('131/100/100/100/110/110/101', payload, msg => console.log("Response: " + msg), err => console.error("Error: " + err))
  })
}


module.exports = { send }