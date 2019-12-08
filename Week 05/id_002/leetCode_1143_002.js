/** 1143. 最长公共子序列 */

/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    if (text1.length === 0 || text2.length === 0) return 0;

    let m = text1.length;
    let n = text2.length;
    let dp = [];

    for (let i = 0; i <= m; i ++) {
        dp[i] = Array(n + 1).fill(0);    
    }

    for (let i = 1; i <=m; i++) {
        for (let j = 1; j <= n; j ++) {
            if (text1.charAt(i - 1) === text2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[m][n];
};

/**
 * 一维空间解法
 * "gzczy"
 *  "gdqbg"
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence2 = function(text1, text2) {
    if (text1.length === 0 || text2.length === 0) return 0;

    let m = text1.length;
    let n = text2.length;
    let dp = Array(n + 1).fill(0);

    for (let i = 1; i <=m; i++) {
        let tmp = 0;
        for (let j = 1; j <= n; j ++) {
            let prev = tmp;
            tmp = dp[j];
            if (text1.charAt(i - 1) === text2.charAt(j - 1)) {
                dp[j] = prev + 1;
            } else {
                dp[j] = Math.max(dp[j], dp[j - 1]);
            }
        }
    }

    return dp[n];
};