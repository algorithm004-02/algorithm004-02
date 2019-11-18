
/**
 * 72.编辑距离
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    //js 写爆栈了
    let n = word1.length;
    let m = word2.length;

    if(n * m == 0) return n + m;

    var cost = Array.from(new Array(n + 1),() => new Array(m + 1));
    //极端情况
    for(let i = 0; i < n + 1; i++)  cost[i][0] = i;
    for(let i = 1; i < m + 1; i++)  cost[0][i] = i;
    //
    for(let i = 0; i < n + 1; i++) {
        for(let j = 0; i < m + 1; j++) {
            if(word1.charAt(i) != word2.charAt(j)) {
                cost[i + 1][j + 1] = Math.min(cost[i][j],cost[i][j + 1],cost[i + 1][j]) + 1;
            }else {
                // 内存会爆栈
                //  let a = cost[i][j];
                //  let b = cost[i][j + 1];
                //  let c = cost[i + 1][j];
                 cost[i + 1][j + 1] = cost[i][j];
            }
        }
    }
    return cost[n][m];
};