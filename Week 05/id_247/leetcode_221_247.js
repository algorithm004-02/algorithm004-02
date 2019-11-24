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
            if (matrix[i - 1][j - 1] !== "0") {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max = Math.max(max, dp[i][j])
            }
        }
    }
    console.log(dp)
    console.log(max)
    return max * max
}

let matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
maximalSquare(matrix)

/**
 * 363. 矩形区域不超过 K 的最大数值和
     给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
     matrix = [ [1, 0,1],
                [0,-2,3] ], k = 2  → 2
 *
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 * 228 ms , 在所有 javascript 提交中击败了 57.69% 的用户
 */

const maxSumSubmatrix = (matrix, k) => {

    let max = -Infinity;
    const m = matrix.length;
    const n = matrix[0].length;

    for (let i = 0; i < n; i++) {
        const rowSum = new Array(m).fill(0);

        for (let j = i; j < n; j++) {
            for (let k = 0; k < m; k++) {
                rowSum[k] += matrix[k][j];
            }

            let sum = 0;
            const arr = [0];

            for (let r = 0; r < m; r++) {
                sum += rowSum[r];

                // js中的Set没有ceiling或者lowerbound方法，
                // 所以实现一个方法查找应当插入值的位置
                let idx = insertIndex(arr, sum - k);

                idx = idx >= arr.length ? arr.length - 1 : idx;
                const val = sum - arr[idx];

                if (idx > -1 && val <= k) {
                    if (val === k) return k;
                    else max = Math.max(max, val);
                }

                const insertIdx = insertIndex(arr, sum);
                if (arr[insertIdx] !== sum)
                    arr.splice(insertIdx, 0, sum);   // 在合适的index位置插入该值，保证arr是个有序数组
            }

        }
    }

    return max;
}

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
function insertIndex(nums, target){

    let low = 0;
    let high = nums.length - 1;
    let mid;

    while (low <= high) {
        mid = (low + high) >> 1;

        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return low;
}