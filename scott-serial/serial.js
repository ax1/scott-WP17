const SerialPort = require('serialport')
const Readline = require('@serialport/parser-readline')

function init(cb) {
  const port = new SerialPort('/dev/serial0', { baudRate: 9600 })
  const parser = new Readline()
  port.pipe(parser)
  parser.on('data', line => cb(line.replace(" ", "")))
}

module.exports = { init }