/** 557. 反转字符串中的单词 III  **/

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split('');
    let n = s.length;
    let i = 0; 
    let j = 0;

    // 学习这段代码
    while(j < n) {
        while(i < j || i < n && arr[i] === ' ') i ++;
        while(j < i || j < n && arr[j] !== ' ') j ++;
        reverse(i, j - 1);
    }

    return arr.join('');

    function reverse(i, j) {
        while(i < j) {
            [arr[i ++], arr[j --]] = [arr[j], arr[i]];
        }
    }
};