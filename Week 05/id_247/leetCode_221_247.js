/**
 * 221. 最大正方形
 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 → 4
 *
 * https://leetcode-cn.com/problems/maximal-square/
 * 1. dp 84 ms , 在所有 javascript 提交中击败了 82.03% 的用户
 */

const maximalSquare = (matrix) => {

    if (!matrix || matrix.length === 0)  return 0

    let max = 0
    let row = matrix.length
    let col = matrix[0].length
    let dp = new Array( row + 1 )

    for (let i = 0; i <= row; i++) {
        dp[i] = new Array( col + 1 ).fill(0)
    }

    for (let i = 1; i <= row; i++) {
        for (let j = 1; j <= col; j++) {
            if (matrix[i - 1][j - 1] === "1") {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max = Math.max(max, dp[i][j])
            }
        }
    }

    return max * max
}