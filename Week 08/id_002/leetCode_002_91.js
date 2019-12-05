/** 91. 解码方法 **/

// DP 
//      a. 重复子问题
//          numDe[i] = if nums[i] + nums[i + 1] < 26: numDe[i + 1] + numDe[i + 2]
//                     if nums[i] === 0: 0
//                     if nums[i] + nums[i + 1] > 26: numDe[i + 1]
//      b. 定义状态数组
//          f[i]
//      c. DP方程
//          f[i] = if nums[i] + nums[i] <= 26 : f[i + 1] + f[i + 2]
//                 if nums[i] + nums[i] > 26 : f[i + 1]
//                 if nums[i] === 0 : 0

/**
 * DP
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    let len = s.length;
    if (len === 0) return 0;
    let dp = Array(len).fill(0);
    if (s[len - 1] !== '0') dp[len - 1] = 1;
    
    if (len === 1) return dp[0];

    for(let i = len - 2; i >= 0; i --) {
        if(s[i] === '0') {
            dp[i] = 0;
        } else if (s[i] + s[i + 1] <= 26) {
            dp[i] = i + 2 >= len ? dp[i + 1] + 1 : dp[i + 1] + dp[i + 2];
        } else {
            dp[i] = dp[i + 1]
        }
    }

    return dp[0];
};