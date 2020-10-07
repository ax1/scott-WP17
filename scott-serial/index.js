/**
 * Start a serial connection and send data to other systems, when serial data arrives.
 * 
 * Usage:
 * - node index           to start app
 * - node index 112233    to start and also send a harvester id on start (useful in development)
 */

const net = require('net')
const PORT = 4444
const serial = require('./serial')
const fetch = require('node-fetch')

const INITIAL_DATA = process.argv[2] ? process.argv[2] : 'TEST START' // do not send a number by default, only when starting with a number. Otherwise the receiver would get a harvester id each time this app is started up.

function socketClient(data) {
  if (!isValidMessage(data)) return
  saveResource("harvester", data, 0).catch(console.error)
  const s = net.Socket()
  s.on('data', data => console.log('response from server: ' + data))
  s.connect(PORT)
  s.write(data) // TODO ARF: this write is not inside a connect(), and if server is not run, write is executed, This is not a problem for this client, but this is not a good example for reusing as tcp client. See the enact for logging SIB data, or  see https://riptutorial.com/node-js/example/22406/a-simple-tcp-client
  s.end()

}

function callback(data){
  console.log(`SCOTT: harvester ID = ${data}`)
  saveResource("harvester",data,0).catch(console.error)
}

function ping() {
  // ping is needed to keep socket running because if NAT in the middle, the default tcp_alive wont work because default is 2 hours and the NAT closes automatically connections idle every 5 minutes
  socketClient('5500') //5+5+0+0=10->PASS
}

async function saveResource(id, value, status) {
  if (!id) throw new Error("id cannot be null")
  const urlResource = `https://rcc.esilab.org/registry/resources/${id}`
  const res = await fetch(urlResource)
  if (res.status >= 400) throw new Error('Error when accessing resource at ' + urlResource + ". Status code=" + res.status)
  const resource = await res.json()
  resource.value = value
  resource.timestamp = Date.now()
  if (status !== null && status != undefined) resource.status = status
  const body = JSON.stringify(resource)
  const response = await fetch(urlResource, { method: 'put', body })
  return response
}

function isValidMessage(value) {
  return (!isEchoMessage() && isConformantValue(value)) ? true : false
}

let timestamp = Date.now()

/**
 * Several echo meessages could arrive, only 1 is needed
 */
function isEchoMessage() {
  const now = Date.now()
  if (now - timestamp < 1000) {
    return true
  } else {
    timestamp = now
    return false
  }
}

/**
 * Discard values sent by other devices
 */
function isConformantValue(value) {
  try {
    if (value.length != 4) return false
    const arr = [...value].map(el => parseInt(el))
    const total = arr.reduce((t, el) => t + el)
    return total === 10 ? true : false
  } catch (err) {
    return false
  }
}

/**
 * Get all stream unhandled errors to trace unknown critical errors
 */
process.addListener('uncaughtException', (err) => {
  console.error('CRITICAL!...PASSING AT **UNCAUGHTEXCEPTION**')
  console.error(err) //log even if logger is disabled!
  console.trace(err)
  process.exit(1)
})

//------------------------------------------
//              RUN
//------------------------------------------
//socketClient(INITIAL_DATA) // send initial data if args have the id when starting. (E.g.: node index 1111)
//setInterval(ping, 120000) // keep app sending PING messages periodically
serial.init(callback) // set a callback function when serial data is arrived
