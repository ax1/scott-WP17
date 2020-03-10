
const { crc } = require('./crc')

module.exports = { message, buildSerial }

function message(id) {
  /**IMPORTANT be sure that the patch is not required when editing this method (see the tests)*/
  const service = JSON.parse(buildMessage(id))
  service.Nodes.forEach(insertCRC)
  insertCRC(service)
  return JSON.stringify(service)
}

function buildMessage(id) {
  const timestamp = Date.now()
  const json = `
  {
    "ServiceID": 131100,
    "Root": {
      "Gateway": 0,
      "Source": 0,
      "TimeStamp": ${timestamp}
    },
    "Nodes": [
      {
        "Safety": false,
        "NodeID": ${id},
        "TimeStamp": ${timestamp},
        "TimeAccuracy": 1000000000,
        "Sensors-Actuators": [
         {
            "SensorID": 3341,
            "TimeStamp": ${timestamp},
            "TimeAccuracy": 143567890,
            "Resources": {
              "5527": "${id}"
            }
          },
          {
            "SensorID": 3336,
            "TimeStamp": ${timestamp},
            "TimeAccuracy": 1000000000,
            "Resources": {
              "5513": "${process.env.LATITUDE}",
              "5514": "${process.env.LONGITUDE}",
              "5516":"100",
              "5518": ${timestamp},
              "5750": "WAGON/CONTAINER"
            }
          }
        ],
        "CRC": 0
      }
    ],
    "CRC": 0
  }
  `

  //check JSON is well format
  JSON.parse(json)
  return json
}

/**Given an object, extract its values and generate the serialized string values */
function buildSerial(obj) {
  const flatObj = flat(obj)
  const keys = Object.keys(flatObj).filter(el => el !== 'CRC')

  // serialize all non-crc values including double quotes if strings [OBSOLETE: and remove non-word characters]
  const canonize = el => (el && el.split) ? `"${el}"` : `${el}`
  const serial = keys.reduce((acc, key) => acc + canonize(flatObj[key]), '')   //const text = keys.reduce((acc, el) => acc + `[${el}]` + String(flatObj[el]), '')
  //.replace(/\W/g, '')
  console.log(serial)
  return serial
}

function insertCRC(obj) {
  const serial = buildSerial(obj)
  const c = crc(serial)
  obj.CRC = c
}

/**
 * Flatten a deep nested object {a{b{c}}}
 */
function flat(ob) {
  var toReturn = {}
  var flatObject
  let keys = Object.keys(ob)
  for (let i of keys) {
    if (!ob.hasOwnProperty(i)) continue
    if ((typeof ob[i]) === 'object') {
      flatObject = flat(ob[i])
      for (var x in flatObject) {
        if (!flatObject.hasOwnProperty(x)) {
          continue
        }
        toReturn[i + (String(x) ? '.' + x : '')] = flatObject[x]
      }
    } else {
      toReturn[i] = ob[i]
    }
  }
  return toReturn
}

