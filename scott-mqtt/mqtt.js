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

function send(harvesterID) {
  const client = mqtt.connect(connectOptions)
  client.on('connect', () => {
    console.log('connected to mqtt server')
    const payload = message(harvesterID)
    const cleanPayload = payload.replace(/(\r\n|\n|\r|\t)/gm, '') // INDRA wants the payload to keep small
    //SERVICE/SUBSERVICE/REGION/SUBREGION/ SOURCE/SUBSOURCE/STATUS/CRCHead/CRCPay
    client.publish('131/100/100/100/110/110/101/204455/308899', cleanPayload, { qos: 1 }, msg => { console.log("Response: " + msg); client.end() }, err => console.error("Error: " + err))
  })
}

function message(id) {
  const containerID = 3652552
  const json = `
  {
    "ServiceID": 131100,
    "Root": {
      "Gateway": 0,
      "Source": 0
    },
    "Nodes": [
      {
        "Safety": false,
        "NodeID": ${id},
        "TimeStamp": ${Date.now()},
        "TimeAccuracy": 1000000000,
        "Sensors-Actuators": [
         {
            "SensorID": 3341,
            "TimeStamp": ${Date.now()},
            "TimeAccuracy": 143567890,
            "Resources": {
              "5527": "${containerID}"
            }
          },
          {
            "SensorID": 3336,
            "TimeStamp": ${Date.now()},
            "TimeAccuracy": 1000000000,
            "Resources": {
              "5513": "${process.env.LATITUDE}",
              "5514": "${process.env.LONGITUDE}",
              "5515":"0",
              "5516":"100",
              "5750": "WAGON/CONTAINER"
            }
          }
        ],
        "CRC": 12237466
      }
    ],
    "CRC": 24495477
  }
  `

  //check JSON is well format
  JSON.parse(json)

  return json
}

module.exports = { send }
