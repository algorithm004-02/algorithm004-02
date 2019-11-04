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
        // 此处代码的意图 是判定二分查找的四种状态 确定区间二分查找
        // 1. target and mid 在旋转节点左半端(较大的一端)
        // 2. target and mid 在旋转节点右半端(较小的一端)
        // 3. target 在旋转节点右半端 mid在左半端
        // 3. target 在旋转节点做半端 mid在右半端
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