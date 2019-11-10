/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  const dict = new Set(wordList);
  let step = 1;
  let q = [beginWord];

  while (q.length) {
    const next = [];
    for (let w of q) {
      if (w === endWord) return step;

      for (let i = 0; i < w.length; i++) {
        for (let j = 0; j < 26; j++) {
          const w2 = w.slice(0, i) + String.fromCharCode(97 + j) + w.slice(i + 1);

          if (dict.has(w2)) {
            next.push(w2);
            dict.delete(w2);
          }
        }
      }
    }
    q = next;
    step++;
  }

  return 0;

};
// @lc code=end