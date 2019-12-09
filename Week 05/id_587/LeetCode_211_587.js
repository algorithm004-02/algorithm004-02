/*
 * @lc app=leetcode.cn id=221 lang=javascript
 *
 * [221] 最大正方形
 */
// @lc code=start
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
    var checkSquare = function (left, size) {
        var x = left[0];
        var y = left[1];
        for (var i = x; i < x + size; i++) {
            for (var j = y; j < y + size; j++) {
                if (matrix[i][j] === '0')
                    return false;
            }
        }
        return true;
    };
    var sideMax = 0;
    for (var i = 0; i < matrix.length; i++) {
        for (var j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] === '1') {
                var iLength = matrix.length;
                var jLength = matrix[i].length;
                var valid = true;
                var currentSize = 1;
                if (valid && currentSize > sideMax) {
                    sideMax = currentSize;
                }
                while (valid) {
                    currentSize++;
                    if (i + currentSize <= iLength && j + currentSize <= jLength) {
                        valid = checkSquare([i, j], currentSize);
                        if (valid && currentSize > sideMax) {
                            sideMax = currentSize;
                        }
                    }
                    else {
                        valid = false;
                    }
                }
            }
        }
    }
    return Math.pow(sideMax, 2);
};
// @lc code=end
