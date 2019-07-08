const mqtt = require('mqtt')
const message = require('./message')
const { crc } = require('./crc')


const TOPIC_HEAD = '131/100/100/100/110/110/101'

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
    const cleanPayload = payload.replace(/(\r\n|\n|\r|\t|\s)/gm, '') // INDRA wants the payload to keep small
    //SERVICE/SUBSERVICE/REGION/SUBREGION/SOURCE/SUBSOURCE/STATUS/CRCHead/CRCPay
    const cleanHead = TOPIC_HEAD.replace('/', '')
    const topic = `${TOPIC_HEAD}/${crc(cleanHead)}/${crc(cleanPayload)}`
    client.publish(topic, cleanPayload, { qos: 1 }, msg => { console.log("Response: " + msg); client.end() }, err => console.error("Error: " + err))
  })
}

module.exports = { send }


