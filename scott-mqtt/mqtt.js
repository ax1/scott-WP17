const mqtt = require('mqtt')
const { message } = require('./message')
const { crc } = require('./crc')


/**
 * TOPIC COMPOSITION (full topic is head + crchead + crcpayload)
 * 
 * 131/100 messages from tecnalia ws
 * 100/100 whatever region
 * 110 tecnalia company
 * 100 messages from harvesters (Idoia can also send other J131100 messages but this value is different than 100, 100 represents MY HARVESTER messages)
 * 100 status, message not processed and it will be processed by cmw itself and then send the same message with status 101. 101 status processed (because the messages I send are always valid because validation/discadrding is done upstream in the SCOTTProducer)
 * LOOKOUT->the message sent is status 100 but cmw will resend the status 101 in topic to subscribers
 */
const TOPIC_HEAD = '131/100/100/100/110/100/100'

const connectOptions = {
  host: process.env.MQTT_HOST,
  port: 8887,
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
    console.log('connected to mqtt server, sending message for harvester ' + harvesterID)
    const payload = message(harvesterID)
    const cleanPayload = payload.replace(/(\r\n|\n|\r|\t|\s)/gm, '') // INDRA wants the payload to keep small
    const cleanHead = TOPIC_HEAD.replace(/\//g, '')
    const CRCHead = crc(cleanHead)
    const CRCPay = crc(cleanPayload)
    const topic = `${TOPIC_HEAD}/${CRCHead}/${CRCPay}` // SERVICE/SUBSERVICE/REGION/SUBREGION/SOURCE/SUBSOURCE/STATUS/CRCHead/CRCPay
    client.publish(topic, cleanPayload, { qos: 1 }, (err, data) => { if (err) console.error('Error:' + err); })
  })

  client.on('error', err => { console.error(err); client.end() })
  client.on('offline', err => { console.error('Cannot connect to MQTT server'); client.end() })
  client.on('disconnect', packet => { console.log('the mqttt server sent a disconnection packet'); client.end() })
  client.on('close', client.end)
  client.on('end', (err, data) => { if (err) console.error(err); })

}

module.exports = { send }


