

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    //1.统计0的个数   可能要写两个Loop  时间复杂度高

    //2.开新的数组 loop


    //3.
    //交换元素法，往前移动，不要的往后移
    //时间复杂度O(n)
    let j = 0;
    for(let i = 0; i < nums.length; i++){
        if(nums[i] != 0) {
           nums[j] = nums[i];
           if(i != j) {
               nums[i] = 0;
           } 
           j++;
        }
    }
    return nums;
};