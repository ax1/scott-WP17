
/**
 * Calculate CRC-32
 * 
 * See https://stackoverflow.com/questions/18638900/javascript-crc32
 * 
 * To test online, see https://crccalc.com/
 */

module.exports = { crc, crcHex }


function crc(r) { for (var a, o = [], c = 0; c < 256; c++) { a = c; for (var f = 0; f < 8; f++)a = 1 & a ? 3988292384 ^ a >>> 1 : a >>> 1; o[c] = a } for (var n = -1, t = 0; t < r.length; t++)n = n >>> 8 ^ o[255 & (n ^ r.charCodeAt(t))]; return (-1 ^ n) >>> 0 }

function crcHex(r) { return crc(r).toString(16).toUpperCase() }
