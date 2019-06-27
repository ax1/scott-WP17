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

function socketClient(data) {
  const s = net.Socket()
  s.on('data', data => console.log('response from server: ' + data))
  s.connect(PORT)
  s.write(data)
  s.end()
}

function ping() {
  //ping is needed to keep socket running because if NAT in the middle, the default tcp_alive wont work because default is 2 hours and the NAT closes automatically connections idle every 5 minutes
  socketClient('222222')
}

const data = process.argv[2] ? process.argv[2] : 'TEST START' // do not send a number by default, only when starting with a number. Otherwise the receiver would get a harvester id each time this app is started up.


//------------------------------------------
//              RUN
//------------------------------------------
socketClient(data) // send initial data if args have the id when starting. (E.g.: node index 1111)
setInterval(ping, 120000) // keep app sending PING messages periodically
serial.init(socketClient) // set a callback function when serial data is arrived
