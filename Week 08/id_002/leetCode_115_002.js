/** 115. 不同的子序列 **/

// 1.dfs
// 2.dp
//      a. 重复子问题
//          dp[i][j] = s[i - 1] === t[i - 1] ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1]
//      b. 定义状态数组
//          dp[i][j] 字符算T(i)所在字符与S(j)所在所在字符
//      c. DP方程
//          dp[i][j] = s[i - 1] === t[i - 1] ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1]

/**
 * dfs
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
    let res = 0;
    dfs(0, 0);
    return res;
    
    function dfs(i, j) {
        if (i > s.length) return;
        
        if (j === t.length) {
            res ++;
            return;
        }

        dfs(i + 1, j);

        if (s[i] === t[j]) dfs(i + 1, j + 1);
    }    
};

/**
 * 时间复杂度为O(S * T) 空间复杂度O(S * T)
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
    let sLen = ("#" + s).length;
    let tLen = ("#" + t).length;

    let dp = Array.from(Array(tLen), (empty, r) => Array(sLen).fill(r === 0 ? 1 : 0));

    for(let i = 1; i < tLen; i ++) {
        for (let j = 1; j < sLen; j ++) {
            dp[i][j] = dp[i][j - 1];
            if (t[i - 1] === s[j - 1]) dp[i][j] += dp[i - 1][j - 1];
        }
    }

    return dp[tLen - 1][sLen - 1];
};