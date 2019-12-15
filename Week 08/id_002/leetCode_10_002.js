/** 10. 正则表达式匹配 **/

/**
 * 
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    if (p.length === 0) return s.length === 0;

    let firstMatch = (s.length !== 0) && (p[0] === s[0] || p[0] === '.') 

    if (p.length >= 2 && p[1] === '*') {
        return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
    } else {
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
};

/**
 * 另一种写法
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    return dp(0, 0);

    function dp(i, j) {
        if (j >= p.length) return i === s.length; 

        let first = (i < s.length) && (s[i] === p[j] || p[j] === '.');
        
        if (j < p.length - 1 && p[j + 1] === '*') {
            return dp(i, j + 2) || first && dp(i + 1, j);
        } else {
            return first && dp(i + 1, j + 1);
        }
    }
};
/**
 * 备忘录（优化）
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    // 备忘录
    let memory = new Map();

    return dp(0, 0);

    function dp(i, j) {
        if (memory.has(`${i},${j}`)) return memory.get(`${i},${j}`);

        if (j >= p.length) return i === s.length; 

        let first = (i < s.length) && (s[i] === p[j] || p[j] === '.');
        
        let ans;
        if (j < p.length - 1 && p[j + 1] === '*') {
            ans = dp(i, j + 2) || first && dp(i + 1, j);
        } else {
            ans = first && dp(i + 1, j + 1);
        }

        memory.set(`${i},${j}`, ans);

        return ans;
    }
};

/** 
    function isMatch2(s, p) {
        if (s.length !== p.length) return false;

        for (let i = 0; i < s.length; i ++) {
            if (s[i] !== p[i]) return false;
        }

        return true;
    }

    function isMatch3(s, p) {
        let i = 0;
        let j = 0;

        while(j < p.length) {
            if (i >= s.length) return false;

            if (s[i++] !== p[j++]) return false;
        }

        return j === s.length;
    }

    function isMatchDfs(s, p) {
        if (p.length === 0) return s.length === 0;

        let firstMatch = (s.length !== 0) && (p[0] === s[0]);

        return firstMatch && isMatchDfs(s.substring(1), p.substring(1));
    }

    // 处理点号「.」通配符
    function isMatch4(s, p) {
        if (p.length === 0) return s.length === 0;

        let firstMatch = (s.length !== 0) && (s[0] === p[0] || p[0] === '.');

        return firstMatch && isMatch4(s.substring(1), p.substring(1));
    }

    // 处理点号「*」通配符
    function isMatch4(s, p) {
        if(p.length === 0) return s.length === 0;

        let firstMatch = (s.length !== 0) && (s[0] === p[0] || p[0] === '.');

        if (p.length >= 2 && p[1] === '*') {
            // 处理通配符 *
            return isMatch4(s, p.substring(2)) || firstMatch && isMatch4(s.substring(1), p);
            // 解释： 如果发现有字符 ‘*’ 结合，
                // 或者匹配该字符 0 次， 然后跳过该字符和‘*’
                // 或者当 p[0] 和 s[0] 匹配后， 移动 s
        } else {
            return firstMatch && isMatch4(s.substring(1), p.substring(1));
        }
    }
**/