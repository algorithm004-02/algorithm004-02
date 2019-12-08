/** 72. 编辑距离 **/

// 1. BFS 双向BFS
// 2. DP
//      .....y (i)
//        ...x (j)
//      a. 重复子问题 
//          if (w1[i] === w2[j]) 
//              edit_dist(i, j) = edit_dist(i - 1, j - 1)
//          else 
//              edit_dist(i, j) = Min(edit_dist(i - 1, j - 1)
//              , edit_dist(i, j) = edit_dist(i - 1, j)
//              , edit_dist(i, j) = edit_dist(i, j - 1)) + 1
//      b. 定义状态数组
//          f[i][j] 
//              word1[:i]
//              word2[:j]
//      c. dp方程
//          f[i][j] = w1[i] === w2[i] ? 
//                  f[i -1][j - 1] 
//                  : 
//                  Min(f[i - 1][j - 1], f[i - 1][j], f[i][j - 1]) + 1

/**
 * 2. DP 解法
 * 时间复杂度 O(m*n) 空间复杂度O(m*n)
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    let len1 = word1.length;
    let len2 = word2.length;

    let dp = Array.from(Array(len1 + 1), () => Array(len2 + 1).fill(0));
    
    for(let i = 0; i <= len1; i ++) {
        dp[i][0] = i;
    }

    for(let j = 0; j <= len2; j ++) {
        dp[0][j] = j;
    }

    for(let i = 1; i <= len1; i++) {
        for (let j = 1; j <= len2; j++) {
            // 代表最后一个字符如果相同， 与dp方程不一样，代表含义相同
            if (word1[i - 1] === word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
    }

    return dp[len1][len2];
};

/**
 * DFS 超出时间限制
 * 时间复杂度O(3^n) 空间复杂度O(n)
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    let len1 = word1.length;
    let len2 = word2.length;
    return dfs(len1, len2);
    
    function dfs(i, j) {
        if (i <= 0 && j <= 0) return 0;

        if (i <= 0) return j;

        if (j <= 0) return i;

        if (word1[i - 1] === word2[j - 1]) {
            return dfs(i - 1, j - 1);
        } else {
            return Math.min(dfs(i - 1, j - 1), dfs(i - 1, j), dfs(i, j - 1)) + 1;
        }
    }
};