/**  32. 最长有效括号 **/

// dp
//      a. 重复子问题
//          if s[i] === '(' 
//              dp[i] = 0;
//          else s[i] === ')'
//              if s[i - 1] === '('
//                  dp[i] = dp[i - 2] + 2
//              else s[i - 1] === ')'
//                  if s[i - dp[i - 1] - 1] === '('
//                      dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
//              
//      b. 定义状态数组
//          dp[i] 第i个括号的最长有效括号对
//      c. dp方程

/**
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    let dp = Array(s.length).fill(0);
    let maxLen = 0;

    for (let i = 1; i < s.length; i ++) {
        if (s[i] !== ')') continue;

        if (s[i - 1] === '(') {
            dp[i] = i > 2 ? dp[i - 2] + 2 : 2;
        } else if (s[i - dp[i - 1] - 1] === '(') {
            dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
        }

        maxLen = Math.max(dp[i], maxLen);
    }

    return maxLen;
};
