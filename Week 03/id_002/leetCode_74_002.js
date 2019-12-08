/*** 74. 搜索二维矩阵 **/


/**
 * 二分行
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let left = 0;
    let right = matrix.length;
    
    while(left < right) {
        let mid = (left + right) / 2 | 0;
        
        if (target < matrix[mid][0]) {
           right = mid;
        } else if (target > matrix[mid][matrix[mid].length - 1]) {
           left = mid + 1;
        } else {
            return findTarget(matrix[mid], target);
        }
    }
    
    return false;
    
    function findTarget(nums, target) {
        let le = 0;
        let ri = nums.length;
        
        while(le < ri) {
            let mid = (le + ri) / 2 | 0;
         
            if (nums[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        
        return nums[ri] === target;
    }
};

/**
 * 二分总体数量
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    if (m === 0) return false;
    let n = matrix[0].length;
    
    let le = 0;
    let ri = m * n - 1;
    
    while(le <= ri) {
        let mid = (le + ri) / 2 | 0;
        
        let r = mid / n | 0;
        let c = mid % n;
        
        if (matrix[r][c] < target) {
            le = mid + 1;
        } else if (matrix[r][c] > target) {
            ri = mid - 1;
        } else if (matrix[r][c] === target) {
            return true;
        }
    }
    
    return false;
};

