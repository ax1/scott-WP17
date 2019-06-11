const dotenv = require('dotenv').config({ path: '../.env' })
const net = require('net')
const { send } = require('./mqtt')
if (dotenv.error) throw dotenv.error
if (!process.env.MQTT_USER) throw new Error('Environment variables are NOT configured!')

const server = net.createServer(function (c) {
  if (!c.localAddress.endsWith('127.0.0.1')) c.end('Error: Only localhost clients are allowed')
  //socket.write('Echo server\r\n');
  //c.on('connection', () => console.dir(c))
  c.on('end', () => console.log('client disconnected'))
  c.on('data', function (data) {
    const sid = data.toString()
    console.log('client data was: ' + sid)
    if (Number.isInteger(Number.parseInt(sid))) send(sid)
    else c.write('Error: ID must be an integer')
  })
})

const port = 4445
server.listen(port)
console.log('Socket server listening at port ' + port)
