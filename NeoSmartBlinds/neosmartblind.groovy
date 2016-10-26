/**
 *  Neo Smart Blind
 *
 *  Bridge for Neo Smart Blind controller with a device
 *  per smart blind connected to the controller.
 *
 *  Author: calem.j.bendell@gmail.com
 *  Date: 2016-10-05
 */

preferences {
  input('deviceId', 'text', title: 'Device ID', required: true)
  // input('token', 'text', title: 'Access Token', required: false)
  input('deviceIp', 'text', title: 'Device IP', required: true)
  input('roomNumber', 'text', title: 'Room Code', required: true)
  input('blindNumber', 'text', title: 'Blind Code', required: true)
}

metadata {
  definition (name: 'Neo Smart Blind', namespace: 'calben', author: 'calem.j.bendell@gmail.com') {
    capability 'Switch'
    command 'transmitUp'
    command 'transmitDown'
    command 'transmitFavorite'
  }
  
  tiles (scale: 2) {
    valueTile('blindup', 'device.switch', width: 2, height: 2, canChangeIcon: false, inactiveLabel: false, decoration: 'flat') {
      state 'default', label:'OPEN', action:'transmitUp'
    }
    valueTile('favorite', 'device.switch', width: 2, height: 2, canChangeIcon: false, inactiveLabel: false, decoration: 'flat') {
      state 'default', label:'FAVORITE', action:'transmitFavorite'
    }
    valueTile('blinddown', 'device.switch', width: 2, height: 2, canChangeIcon: false, inactiveLabel: false, decoration: 'flat') {
      state 'default', label:'CLOSE', action:'transmitDown'
    }
    
    main(['favorite'])
    details(['blindup', 'favorite', 'blinddown'])
  }
}


def on() {
  transmitLocal('145.002-' + blindNumber + '-up')
}

def off() {
  transmitLocal('145.002-' + blindNumber + '-dn')	
}

def parse(String description) {
  log.error 'This device does not support incoming events'
  return null
}


def transmitUp() {
  transmitLocal('145.002-' + blindNumber + '-up')
}

def transmitDown() {
  transmitLocal('145.002-' + blindNumber + '-dn')
}

def transmitFavorite() {
  transmitLocal('145.002-' + blindNumber + '-gp')
}

/*
private transmitCloud(command) {
    log.debug 'running transmitCloud with args: ' + command
  httpPost(
    uri: 'https://api.particle.io/v1/devices/${deviceId}/transmit',
    body: [access_token: token, command: command],  
  ) {response -> log.debug (response.data)}
}
*/

private transmitLocal(command) {
  def result = new physicalgraph.device.HubAction(
    method: 'GET',
    path: '/neo/v1/transmit?command=' + command + '&id=' + deviceId,
    headers: [
      HOST: deviceIp + ':8838',
    ]
  )
  log.debug result
  result
}
