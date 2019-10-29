/*
 * @lc app=leetcode id=242 lang=javascript
 *
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    // ------------------------- 解法 1 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    // const map = {};
    // s.split('').map(c => map[c] = map[c] ? map[c] + 1 : 1);  //拆解单词,空对象对比并记录字母数量
    // t.split('').map(c => map[c] = map[c] ? map[c] - 1 : -1); //拆解单词,实对象对比并刷新字母数量
    // return Object.keys(map).every(k => map[k] === 0); // every: 测试数组, 一假即假
    /** 🚩 相同解法，for的执行性能要高于foreach更高于map  */
    // const map = {};
    // for (let c of s) map[c] = (map[c] || 0) + 1;
    // for (let c of t) if (!map[c]--) return false;
    // return Object.values(map).every(v => !v);
    
    // ------------------------- 解法 2 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘
    // return s.split('').sort().join('') == t.split('').sort().join('') //拆解重排合并对比是否一致

    // ------------------------- 解法 3 start --------------------------
    // 最好记  👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘
    const map = {};
    for (let i = 0; i < s.length; i++) {
        map[s[i]] ? map[s[i]]++ : map[s[i]] = 1;
    }
    for (let i = 0; i < t.length; i++) {
        if (map[t[i]]) map[t[i]]--;
        else return false;    
    }
    return true;
};
// @lc code=end

isAnagram(
    "anagram",
"nagaram"
)