const net = require('net')
const PORT = 4444

function socketClient(data) {
  const s = net.Socket()
  s.connect(PORT)
  s.write(data)
  s.end()
}


function ping() {
  //ping is needed to keep socket running because if NAT in the middle, the default tcp_alive wont work because default is 2 hours and the NAT closes automatically connections idle every 5 minutes
  socketClient('PING')
}

const data = process.argv[2] ? process.argv[2] : 'test message'

socketClient(data)
setInterval(ping, 120000)
