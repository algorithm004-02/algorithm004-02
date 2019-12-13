/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 * 解法1：排序后比较
 * 解法2：哈希表
 */

// @lc code=start
/**
 * 解法1：排序后比较
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false
  }
  return s.split('').sort().join('') === t.split('').sort().join('')
};
// @lc code=end

// @lc code=start
/**
 * 解法2：哈希映射
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false
  const alpha = new Array(27).fill(0)
  for (let i = 0; i < s.length; i++) {
    alpha[s.charCodeAt(i) - 96]++
    alpha[t.charCodeAt(i) - 96]--
  }
  for (let i = 0; i < alpha.length; i++) {
    if (alpha[i] !== 0) return false
  }
  return true
  
};
// @lc code=end

