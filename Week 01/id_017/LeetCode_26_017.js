

/**
 * 26.删除排序数组中的重复项
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    //统计重复的数
    var count = 0;
    for(let i=0; i<nums.length; i++) {
        if(nums[i] === nums[i-1]) {
           count++;
        }else {
           //不重复的往前移
           nums[i-count] = nums[i];
        }
    }
    return nums.length - count;
};

