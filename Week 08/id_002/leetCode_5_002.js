/** 5. 最长回文子串 **/
// 1. 暴力解法O(n^3)
// 2. 中间向两边扩张O(n^2)
// 3. 动态规划
//      DP
//          a. 重复子问题
//              p(i, j) = (p(i + 1, j - 1) && s[i] === s[j])
//          b. 定义状态数组
//              dp[i][j] i起点 j终点  true || false dp[i][j] 是否回文串
//          c. dp方程

/**
 * 2 中间向两边扩张O
 * 空间复杂度O(n^2) 
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let lo = 0, maxLen = 0;
    let len = s.length;

    if (len < 2) return s;

    for(let i = 0; i < len; i++) {
        extendRome(i, i);
        extendRome(i, i + 1);
    }

    return s.substring(lo, lo + maxLen);

    function extendRome(j, k) {
        while(j >= 0 && k < len && s[j] === s[k]) {
            j --, k ++;
        }

        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
};


/**
 * DP
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let n = s.length;
    let res = "";
    let dp = Array.from(Array(n), () => Array(n).fill(0));

    for(let i = n - 1; i >= 0; i--) {
        for (let j = i; j < n; j ++) {
            dp[i][j] = (s[i] === s[j]) && (j - i < 2 || dp[i + 1][j - 1]);

            if (dp[i][j] && (j - i + 1 > res.length)) {
                res = s.substring(i, j + 1);
            }
        }
    }

    return res;
};