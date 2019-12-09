/** 387. 字符串中的第一个唯一字符 **/

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let count = Array(256).fill(0);  

    for(let i = 0; i < s.length; i++) {
        let code = s.charCodeAt(i);
        count[code] ++;
    }

    for(let i = 0; i < s.length; i++) {
        let code = s.charCodeAt(i);
        if (count[code] === 1) return i;
    }

    return -1;
}

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let map = {};

    for(let i of s) {
        if (!map[i]) {
            map[i] =  1;
        } else {
            map[i] ++;
        }
    }

    for(let i = 0; i < s.length; i++) {
        if (map[s[i]] === 1) return i;
    }

    return -1;
}