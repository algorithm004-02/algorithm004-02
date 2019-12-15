
/**
 * 242.有效的字母异位词
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    //暴力解法，sort，判断是否相等
//     if (s.length !== t.length) return false;
    
//     return s.split("").sort().join('') === t.split("").sort().join('');
    
    //hash Map，统计次数
    if (s.length !== t.length) return false;
    
    let counts = {}; 
    
    for (let c of s) {
        counts[c] = (counts[c] || 0) + 1;
    }
    
    for (let c of t) {
        if(!counts[c]) return false;
        counts[c] --;
    }
    
    return true;
    
};