/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let bits = 0;
    let mask = 1;
    for (let i = 0; i < 32; i++) {
      if ((n & mask) !== 0) {
        bits++;
      }
      mask <<= 1;
    }
    return bits;
};
// @lc code=end


// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  let sum = 0;
  while (n !== 0) {
    sum++
    n &= (n - 1);
  }
  return sum;
};
// @lc code=end
