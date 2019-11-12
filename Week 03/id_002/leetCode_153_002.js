/** 153. 寻找旋转排序数组中的最小值 */

/**
 * 二分查找
 * 时间复杂度O(logn) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let left = 0;
    let right = nums.length - 1;
    
    while(left < right) {
        let mid = (left + right) / 2 | 0;
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return nums[right];
};

/**
 * 分治
 * 时间复杂度O(logn) 空间复杂度O(log n)
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let left = 0;
    let right = nums.length - 1;
    
    if (nums[left] < nums[right]) return nums[0];
    
    return getMin(left, right);
    
    function getMin(left, right) {
        if (nums[left] === nums[right]) return nums[left];
        
        if (nums[left + 1] === nums[right]) return Math.min(nums[left], nums[right]);
        
        let mid = (left + right) / 2 | 0;
        
        if (nums[mid] > nums[0]) {
            return getMin(mid + 1, right);
        } else {
            return getMin(left, mid);
        }  
    }
};