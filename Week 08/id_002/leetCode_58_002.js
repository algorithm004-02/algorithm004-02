/** 58. 最后一个单词的长度  **/
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let end = s.length - 1;

    while(end >= 0 && s[end] === ' ') end --; 
    if (end < 0) return 0;

    let st = end;
    while(st >=0 && s[st] !== ' ') st--;
    return end - st;
};