
/**
 * 221.最大正方形
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if (matrix.length < 1) return 0; 
    let memo = []; 
    let result = 0;
    //创建一个二维数组
    for (let i = 0; i <= matrix.length; i++) {
        memo.push([]);
        for (let k = 0; k <= matrix[0].length; k++) {
            memo[i][k] = 0; 
        }
    }
    //dp 
    for (let l = 1; l <= matrix.length; l++) {
        for (let m = 1; m <= matrix[0].length; m++) {
            if (matrix[l-1][m-1] == "1") {
                memo[l][m] = Math.min(memo[l-1][m], memo[l][m-1], memo[l-1][m-1]) + 1;
                result = Math.max(memo[l][m],result);
            }
        }
    }
    return result * result;

};