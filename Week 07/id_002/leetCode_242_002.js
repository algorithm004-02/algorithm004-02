/**
 * 计数
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length != t.length) return false;

    let countMap = {};
    for(let l of s) {
        countMap[l] ? countMap[l] ++ : (countMap[l] = 1);
    }
    
    for (let l of t) {
        if (!countMap[l]) return false;
        countMap[l] --;
    }

    return true;
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) { 
    if (s.length !== t.length) return false;

    let map = Array(256).fill(0);
    for (let i = 0; i < s.length; i++) {
        let code = s.charCodeAt(i);
        map[code] ++;
    }

    for(let i = 0; i < t.length; i ++) {
        let code = t.charCodeAt(i);
        if (map[code] === 0) return false;
        map[code] --;
    }

    return true;
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    return s.split('').sort().join('') === t.split('').sort().join('');
};