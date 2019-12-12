/** 680. 验证回文字符串 Ⅱ **/

/**
 * 双指针解法 时间复杂度 O(n) 空间复杂度O(1)
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    let i = 0;
    let j = s.length - 1;

    while(i < j && s[i] === s[j]) {
        i ++, j --;
    }

    if (isValid(i + 1, j)) return true;
    if (isValid(i, j - 1)) return true;

    return false;
    
    function isValid(i, j) {
        while(i < j) {
            if (s[i] !== s[j]) return false;
            i ++, j --;
        }

        return true;
    }
};