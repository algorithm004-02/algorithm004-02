/** 242. 有效的字母异位词 */

 /**
 * 第一种解法 暴力解法 sort 比较字符串
 * 时间复杂度O(nlogn) 空间复杂度O(1)
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;

    let s1 = s.split('').sort().toString();
    let s2 = t.split('').sort().toString();
    return s1 === s2;
};

/**
 * 第二种解法 hash, map --> 统计每个字符的频次
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {String} s 
 * @param {String} t 
 */
var isAnagram2 = function(s, t) {
    if (s.length !== t.length) return false;

    let map = {};
    s.split('').map(s => map[s] = map[s] ? ++ map[s] : 1);
    t.split('').map(s => map[s] = map[s] ? -- map[s] : 1);
    
    return Object.keys(map).every(k => map[k] === 0);
}

/**
 * 第三种解法 hash, map --> 统计每个字符的频次
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {String} s 
 * @param {String} t 
 */
var isAnagram3 = function(s, t) {
    if (s.length !== t.length) return false;
    const map = {};
    
    for (let i = 0; i < s.length; i++) {
        map[s[i]] ? map[s[i]]++ : map[s[i]] = 1;
    }
    
    for (let i = 0; i < t.length; i++) {
        if (map[t[i]]) map[t[i]]--;
        else return false;
    }
    
    return true;
}