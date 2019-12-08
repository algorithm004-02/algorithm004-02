/** 32. 最长有效括号 */

// 1. 暴力解法

// 2. DP
//我们用 dp[i] 表示以 i 结尾的最长有效括号；
//当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
//那么 s[i] 为 )
//2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
//2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；....()) dp[i - 1]前一个字符 '('
// 2.2 注意边界问题 dp[i - 2] 与 dp[i - dp[i - 1] - 2] 越界问题
// DP:
//      a. 重复子问题
//          dp[i] = dp[i - 2] + 2 || dp[i-1] + 2 + dp[i-dp[i-1]-2]      
//      b. 定义状态数组
//          fn[i]
//      c. DP方程
//          f[i] = dp[i - 2] + 2 || dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]

/**
 * DP解法
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    let dp = Array(s.length).fill(0);
    let maxLen = 0;

    for(let i = 1; i < s.length; i ++) {
        if (s.charAt(i) !== ')') continue;

        if (s.charAt(i - 1) === '(') {
            dp[i] = i > 2 ? dp[i - 2] + 2 : dp[i - 1] + 2;
        } else if (s.charAt(i - dp[i - 1] - 1) === '(') {
            dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
        }
        
        maxLen = Math.max(maxLen, dp[i]);
    }    

    return maxLen;
};