/** 44. 通配符匹配 **/

/**
  * 时间复杂度为O(4^n) n 为匹配串和模式串的平均长度 空间复杂度为 O(p * s) p为模式串的长度 s匹配串的长度
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let _cache = new Map();

    return dfs(s, p);

    function dfs(s, p) {
        let key = `${s},${p}`;
        if (_cache.has(key)) return _cache.get(key);
      
        if (p.length === 0) return s.length === 0;
        
        // 匹配第一个单词
        let firstMatch = (s.length !== 0) && (p[0] === s[0] || p[0] === '?');
        
        let ans = false;
        
        // 处理*逻辑
        if (p[0] === '*') {
            // 如果要匹配的串为空 就推进模式串
            if (s.length === 0) {
                ans = dfs(s, p.substring(1));
            } else { // 进入模式串 * 匹配模式

                // 剪枝1：发现模式串的下一位也是 * 则模式串推进一位
                if (!ans && p[1] === "*") {
                    ans = dfs(s, p.substring(1));
                }
                
                // 剪枝2： 发现模式串下一位与匹配串的下一位相同(包括匹配串的?) 两者都推进一位
                if (!ans && (p[1] === s[1] || p[1] === '?')) {
                    ans = dfs(s.substring(2), p.substring(2));
                }

                // 剪枝3：发现模式串的下一位与匹配串的当前字符相同 匹配串前进一位
                if (!ans && (p[1] === s[0] || p[1] === '?')) {
                    ans = dfs(s, p.substring(1));
                }

                // 剪枝4： 匹配串向前推进一位
                if (!ans) {
                   ans = dfs(s.substring(1), p);
                } 
            }
        } else {
            ans = firstMatch && dfs(s.substring(1), p.substring(1));
        }

        if (!_cache.has(key)) _cache.set(key, ans);

        return ans;
    }
};

// 题解思路 https://www.cnblogs.com/grandyang/p/4401196.html
/**
 * 时间复杂度为O(m * n) m,n分别为匹配串与模式串的长度， 空复杂度为O(1）
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let i = 0, j = 0, m = s.length, n = p.length;
    let iStar = -1, jStar = -1;

    while(i < m) {
        // 处理相等字符
        if (j < n && (s[i] === p[j] || p[j] === '?')) {
            i ++, j ++;
        } else if (j < n && p[j] === '*') {
        // 处理「*」 模式串前进一位
            iStar = i;
            jStar = j ++;
        } else if (iStar >= 0) {
        // 发现没有匹配， 用『*』补救
            i = ++iStar;
            j = jStar + 1;
        } else {
            return false;
        }
    }

    while(j < n && p[j] === '*') j ++;

    return j === n;
};

// dp
//      初始化dp[m][n] m s串的长度 n为p串的长度
//      for k < n  if p[k - 1] === '*' dp[0][k] = dp[0][k - 1];
//      a. 重复子问题
//         if p[j - 1] === '*'
//             dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//         else 
//             dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] === p[j - 1] || (p[j - 1] === '?') 
//      b. 定义状态数组
//          dp[i][j] 表示 s中前i个字符组成的子串和p中前j个字符组成的子串是否能匹配
//      c. dp方程

/**
 * dp
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let i = 0, j = 0, m = s.length, n = p.length;

    let dp = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    dp[0][0] = true;

    // 处理s为空 p为连续*
    for (let k = 0; k <= n; k ++) {
        if (p[k - 1] === '*') dp[0][k] = dp[0][k - 1];
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j ++) {
            if (p[j - 1] === '*') {
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            } else {
                dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] === p[j - 1] || p[j - 1] === '?');
            }
        }
    }

    return dp[m][n];
};