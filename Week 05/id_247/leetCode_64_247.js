/**
 * 64. 最小路径和
 给定一个包含非负整数的 m * n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 说明：每次只能向下或者向右移动一步。
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 → 7
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * 1. dp: 64 ms , 在所有 javascript 提交中击败了 94.09% 的用户
 */

const minPathSum = (grid) => {

    if (grid.length === 0)  return 0

    const r = grid.length
    const c = grid[0].length

    for (let i = 0; i < r; i++) {

        for (let j = 0; j < c; j++) {

            if (i === 0 && j === 0)
                continue
            if (i === 0)
                grid[i][j] += grid[i][j - 1]
            else if (j === 0)
                grid[i][j] += grid[i - 1][j]
            else
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j])
        }
    }

    return grid[r - 1][c - 1]
}