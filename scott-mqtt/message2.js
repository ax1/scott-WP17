module.exports = message

function message(id) {
  const message = JSON.parse(buildMessage(id))
  message.Nodes.forEach(insertCRC)

}

function buildMessage(id) {
  const containerID = 3652552
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
              "5527": "${containerID}"
            }
          },
          {
            "SensorID": 3336,
            "TimeStamp": ${timestamp},
            "TimeAccuracy": 1000000000,
            "Resources": {
              "5750": "WAGON/CONTAINER",
              "5513": "${process.env.LATITUDE}",
              "5514": "${process.env.LONGITUDE}",
              "5516":"100",
              "5518": ${timestamp}
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


function insertCRC(obj) {
  const flatObj = flat(obj)
  const keys = Object.keys(flatObj).filter(el => el !== 'CRC')
  console.dir(keys)

  // serialize all non-crc values including double quotes if strings [OBSOLETE: and remove non-word characters]
  //const text = keys.reduce((acc, el) => acc + `[${el}]` + String(flatObj[el]), '')
  const canonize = el => (el && el.split) ? `"${el}"` : `${el}`
  const text = keys.reduce((acc, key) => acc + canonize(flatObj[key]), '')
  //.replace(/\W/g, '')

  console.log(text)
}

function flat(ob) {
  var toReturn = {}
  var flatObject
  for (var i in ob) {
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

const obj2 = {
  "Safety": true,
  "NodeID": 1,
  "TimeStamp": 1536230820,
  "TimeAccuracy": 143567890,
  "Sensors-Actuators": [
    {
      "SensorID": 3306,
      "TimeStamp": 1536230220,
      "TimeAccuracy": 143567890,
      "Resources": {
        "5850": true
      }
    }
  ],
  "CRC": 3390527143
}

const obj3 = {
  "Safety": false,
  "NodeID": 1,
  "TimeStamp": 1536230850,
  "TimeAccuracy": 143567890,
  "Sensors-Actuators": [
    {
      "SensorID": 3341,
      "TimeStamp": 1536230330,
      "TimeAccuracy": 143567890,
      "Resources": {
        "5527": "0000000000000000000011672"
      }
    }
  ],
  "CRC": 3620125633
}

const obj = JSON.parse('{"Safety": false, "NodeID": 1, "TimeStamp": 1536230850, "TimeAccuracy": 143567890, "Sensors-Actuators": [{"SensorID": 3341, "TimeStamp": 1536230330, "TimeAccuracy": 143567890, "Resources": {"5527": "0000000000000000000011672"}}, {"SensorID": 3341, "TimeStamp": 1536231220, "TimeAccuracy": 143567890, "Resources": {"5527": "0000000000000000000011672"}}, {"SensorID": 3336, "TimeStamp": 1536230330, "TimeAccuracy": 143567890, "Resources": {"5750": "WAGON/CONTAINER", "5513": "43.138453", "5514": "-2.556184", "5516": "100", "5518": 1536230850}}, {"SensorID": 3341, "TimeStamp": 1536230220, "TimeAccuracy": 143567890, "Resources": {"5527": "Observationsandcomments"}}]}')
console.log(insertCRC(obj))