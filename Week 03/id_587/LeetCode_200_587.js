/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */
// @lc code=start
var xNearbyPoints = [0, 1, 0, -1];
var yNearbyPoints = [1, 0, -1, 0];
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    var result = 0;
    for (var i = 0; i < grid.length; i++) {
        for (var j = 0; j < grid[i].length; j++) {
            var island = grid[i][j];
            if (island === '1') {
                grid[i][j] = '0';
                result++;
                sink(grid, i, j);
            }
        }
    }
    return result;
};
var sink = function (grid, i, j) {
    for (var index = 0; index < xNearbyPoints.length; index++) {
        var newI = i + xNearbyPoints[index];
        var newJ = j + yNearbyPoints[index];
        if (newI >= 0 &&
            newJ >= 0 &&
            newI < grid.length &&
            newJ < grid[0].length &&
            grid[newI][newJ] === '1') {
            grid[newI][newJ] = '0';
            sink(grid, newI, newJ);
        }
    }
};
// @lc code=end
