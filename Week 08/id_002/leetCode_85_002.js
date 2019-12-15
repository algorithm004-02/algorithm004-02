/** 85. 最大矩形 **/

// DP
//  https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
//      a. 重复子问题
//          for i range(0, m) 
//              curL =0, curR = n;
//              for j range(0, n)
//                  if matrix[i][j] === '1'
//                      left(i, j) = Math.max(left(i - 1, j), curL);
//                      right(i, j) = Math.min(right(i - 1, j), curR);
//                      height(i, j) += 1
//                  else 
//                      curL = j + 1;
//                      left(i, j) = 0;
//
//                      curR = j;
//                      right(i, j) = n;
//
//                      height(i, j) = 0;
//
//                  maxA = max(maxA, (right(i, j) - left(i, j)) * height[i][j])
//      b. 定义状态数组
//          left[i][j] (i, j) 左边边距 
//          right[i][j] (i, j) 右边边距 
//          height[i][j] (i, j) 高度
//          area[i][j] = (right[i][j] - left[i][j]) * height[i][j]
//      c. 定义状态数组

/**
 * dp
 * 时间复杂度O(m*n) 空间复杂度O(n)
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    let m = matrix.length;

    if (m === 0) return 0;
    
    let n = matrix[0].length;
     
    let left = Array(n).fill(0);
    let right = Array(n).fill(n);
    let height = Array(n).fill(0);

    let maxA = 0;

    for (let i = 0; i < m; i++) {
        let curL = 0;
        let curR = n;

        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '1') {
                height[j] ++;
            } else {
                height[j] = 0;
            }
        }

        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '1') {
                left[j] = Math.max(left[j], curL);
            } else {
                left[j] = 0;
                curL = j + 1;
            }
        }

        for (let j = n - 1; j >= 0; j --) {
            if (matrix[i][j] === '1') {
                right[j] = Math.min(right[j], curR)
            } else {
                right[j] = n;
                curR = j;
            }
        }

        for(let j = 0; j < n; j++) {
            maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
        }
    }

    return maxA;
};

