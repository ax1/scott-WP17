const net = require('net')
const PORT = 4444

function socketServer() {
  net.createServer(function (socket) {
    socket.on('data', data => console.log(data.toString()))
  }).listen(PORT)
}


function socketClient(name) {
  const s = net.Socket()
  s.connect(PORT)
  s.write(name)
  s.end()
}

if (process.argv.length < 3) socketServer()
else socketClient(process.argv[2])
