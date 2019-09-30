const SerialPort = require('serialport')
const Readline = require('@serialport/parser-readline')

function init(cb) {
  const port = new SerialPort('/dev/ttyUSB0', { baudRate: 9600 })
  port.on('error', stopGraceFully)
  port.on('close', stopGraceFully)  // if temporary disconnection, error event is not triggered, but close is, so treat close the same as error
  const parser = new Readline()
  port.pipe(parser)
  parser.on('data', line => cb(line.replace(" ", "").replace('\r', '')))
  parser.on('error', stopGraceFully)
}

function stopGraceFully(err) {
  console.error(err); process.exit(1)
}
module.exports = { init }