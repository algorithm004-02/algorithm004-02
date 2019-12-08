/** 跳跃游戏 */

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let maxPosi = 0;
    let end = 0;
    let steps = 0;
    
    for (let i = 0; i < nums.length - 1; i ++) {
        maxPosi = Math.max(maxPosi, i + nums[i]);
        if (i === end) {
            end = maxPosi;
            steps ++;
        }
    }
    
    return steps;
};

/**
 * 时间复杂度为O(n^2) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var jump2 = function(nums) {
    let posi = nums.length - 1;
    let steps = 0;
    while (posi !== 0) {
        for (let i = 0; i < posi; i ++) {
            if (i + nums[i] >= posi) {
                posi = i;
                steps ++;
            }
        }
    }
    
    return steps;
};