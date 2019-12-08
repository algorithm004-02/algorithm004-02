/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 思路：把两个字符串转换为数组，然后排序，接着拼接回字符串判断两个是否相等
// 时间复杂度 O(nlogN);
// var isAnagram = function (s, t) {
//   return s.split('').sort().join('') == t.split('').sort().join('');
// };

// 哈希，手动维护一个对象，记录字母存在的情况，复杂度 O(n)
var isAnagram = function (s, t) {
  // 如果长度不相等则返回 false
  if (s.length !== t.length) return false;

  const map = {};

  for (let i of s) {
    if (map[i] == null) {
      map[i] = 0;
    }
    map[i]++;
  }

  for (let i of t) {
    if (map[i] > 0) {
      map[i]--;
    } else {
      return false;
    }
  }

  return true;
}
// @lc code=end