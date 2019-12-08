/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  g = g.sort((a, b) => (a - b));
  s = s.sort((a, b) => (a - b));

  let result = 0;

  for(let i = 0, j = 0; j < s.length; j++) {
    if (i === g.length) break;
    if (g[i] <= s[j]) {
      ++result;
      ++i;
    }
  }

  return result;
};
// @lc code=end