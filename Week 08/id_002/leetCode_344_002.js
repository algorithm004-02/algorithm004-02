/** 344. 反转字符串 **/

/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    let i = 0; 
    let j = s.length - 1;
    while(i < j) {
        [s[i ++], s[j --]] = [s[j], s[i]];
    } 

    return s;
};