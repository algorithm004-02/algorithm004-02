/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n === 1) return 1
    let m = []
    m[1] = 1
    m[2] =2
    for (let i = 3; i <= n; i++) {
      m[i] = m[i - 1] + m[i - 2]
    }
    return m[n]
};
// @lc code=end

