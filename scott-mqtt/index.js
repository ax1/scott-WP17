const dotenv = require('dotenv').config({ path: '../.env' })
const net = require('net')
const { send } = require('./mqtt')
if (dotenv.error) throw dotenv.error
if (!process.env.MQTT_USER) throw new Error('Environment variables are NOT configured!')

const server = net.createServer(function (c) {
  //socket.write('Echo server\r\n');
  c.on('end', () => console.log('client disconnected'))
  c.on('data', function (data) {
    console.log('client data: ' + data.toString())
    send(data)
  })
})

const port = 4445
server.listen(port)
console.log('Socket server listening at port ' + port)
