const SerialPort = require('serialport')
const Readline = require('@serialport/parser-readline')

function init(cb) {
  const port = new SerialPort('/dev/ttyUSB0', { baudRate: 9600 })
  port.on('error', err => { console.error(err); process.exit(1) })
  const parser = new Readline()
  port.pipe(parser)
  parser.on('data', line => cb(line.replace(" ", "").replace('\r', '')))
}

module.exports = { init }