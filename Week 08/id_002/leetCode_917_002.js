/** 917. 仅仅反转字母 **/
// 1. 双指针解法
// 2. 栈解法

/**
 * 1. 双指针解法
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function(S) {
    let arr = S.split('');
    let n = arr.length;
    let i = 0, j = n - 1;

    while(i < j) {
        while(i < j && !validCharCode(i)) i ++;
        while(i < j && !validCharCode(j)) j --;

        if (i < j) {
            [arr[i++], arr[j--]] = [arr[j], arr[i]];
        }
    }

    return arr.join('');

    function validCharCode(i) {
        let code = S.charCodeAt(i)
        return (code >= 97 && code <= 122) || (code >= 65 && code <= 90);
    }
};