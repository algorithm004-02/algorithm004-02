/** 10. 正则表达式匹配 **/

/**
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