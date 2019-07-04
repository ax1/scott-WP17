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
  const s = net.Socket()
  s.on('data', data => console.log('response from server: ' + data))
  s.connect(PORT)
  s.write(data)
  s.end()
  const value = ('' + Date.now()).substring(9)
  saveResource("harvester", value, 0).catch(err => console.error(err))
}

function ping() {
  // ping is needed to keep socket running because if NAT in the middle, the default tcp_alive wont work because default is 2 hours and the NAT closes automatically connections idle every 5 minutes
  socketClient('222222')
}

async function saveResource(id, value, status) {
  if (!id) throw new Error("id cannot be null")
  const urlResource = `https://rcc.esilab.org/registry/services/resources/${id}`
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

//------------------------------------------
//              RUN
//------------------------------------------
socketClient(INITIAL_DATA) // send initial data if args have the id when starting. (E.g.: node index 1111)
setInterval(ping, 120000) // keep app sending PING messages periodically
serial.init(socketClient) // set a callback function when serial data is arrived