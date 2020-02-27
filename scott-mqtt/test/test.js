const net = require('net')
const util = require('a1-util')

console.log('Usage:\n  - start `node index` first, then execute test')

const PORT = 4445

function socketClient(sid) {
  const s = net.Socket()
  s.connect(PORT)
  s.write(sid)
  s.on('data', data => data.toString().toLowerCase().startsWith('error') ? util.logError(data.toString()) : util.logOK(sid))
  s.end()
}

try {
  socketClient("112233")
  socketClient("AAAAA112233")
} catch (err) {
  console.error(err)
  util.logError('Tests failed')
}
