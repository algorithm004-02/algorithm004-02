/** 709. 转换成小写字母 **/

/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    let res = '';

    for(let s of str) {
        let code = s.charCodeAt();
        if (code <= 90 && code >= 65) {
            res += String.fromCharCode(code + 32);
        } else {
            res += s;
        }
    }

    return res;
};

/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    let res = '';

    for(let s of str) {
        let code = s.charCodeAt();
        res += String.fromCharCode(code | 32);
    }

    return res;
};

/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    return str.toLocaleLowerCase();
};