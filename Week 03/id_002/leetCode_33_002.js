/** 33. 搜索旋转排序数组 **/

/**
 * 暴力解法
 * 时间复杂度 O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === target) return i;
    }

    return 0;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search2 = function(nums, target) {
    let roatIndex = getRoatIndex(nums);

    // nums为空
    if (roatIndex < 0) return roatIndex;
    
    let le = 0;
    let ri = nums.length - 1;

    //取数组的两端 规避数组长度为1或2边界
    if (nums[ri] === target) return ri;
    if (nums[le] === target) return le;
    if (le === ri) return -1;
    
    //规避有序的数组（默认）
    if (nums[le] > nums[ri]) {
        if (nums[roatIndex] === target) return roatIndex;
        if (target > nums[0]) ri = roatIndex - 1;   
        if (target < nums[0]) le = roatIndex;
    }
    return binarySearch(le, ri);  

    function getRoatIndex(nums) {
        let len = nums.length;
        let left = 0;
        let right = len - 1;
    
        while(left <= right) {
            let mid = (left + right) / 2 | 0;
            
            if (nums[mid] === nums[right]) return mid;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            } 
        }
        
        return -1;
    }
    function binarySearch(le, ri) {
        while(le < ri) {
            let mid = (le + ri) / 2 | 0;
            if (nums[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        
        return nums[ri] === target ? ri : -1;
    }
};
/**
 * 第三种精简解法
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search3 = function(nums, target) {
    let left = 0;
    let right = nums.length;
    
    while(left < right) {
        let mid = (left + right) / 2 | 0;
        let num = (nums[mid] < nums[0]) === (target < nums[0]) ? nums[mid] : target < nums[0] ? -Number.POSITIVE_INFINITY : Number.POSITIVE_INFINITY;
        if (num < target) 
            left = mid + 1;
        else if(num > target)
            right = mid;
        else
            return mid;
    }
    
    return -1;
};