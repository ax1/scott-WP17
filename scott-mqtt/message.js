module.exports = message

function message(id) {
  const containerID = 3652552
  const json = `
  {
    "ServiceID": 131100,
    "Root": {
      "Gateway": 0,
      "Source": 0
    },
    "Nodes": [
      {
        "Safety": false,
        "NodeID": ${id},
        "TimeStamp": ${Date.now()},
        "TimeAccuracy": 1000000000,
        "Sensors-Actuators": [
         {
            "SensorID": 3341,
            "TimeStamp": ${Date.now()},
            "TimeAccuracy": 143567890,
            "Resources": {
              "5527": "${containerID}"
            }
          },
          {
            "SensorID": 3336,
            "TimeStamp": ${Date.now()},
            "TimeAccuracy": 1000000000,
            "Resources": {
              "5513": "${process.env.LATITUDE}",
              "5514": "${process.env.LONGITUDE}",
              "5515":"0",
              "5516":"100",
              "5750": "WAGON/CONTAINER"
            }
          }
        ],
        "CRC": 12237466
      }
    ],
    "CRC": 24495477
  }
  `

  //check JSON is well format
  JSON.parse(json)

  return json
}


