/** 两数之和 */

/**
 * 暴力求解
 * 时间复杂度O(n^2) 空间复杂度O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for(let i = 0; i < nums.length; i ++) {
        for(let j = i + 1; j < nums.length; j ++) {
            if (nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
    
    return [];
};

/**
 * 两遍map
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = {};
    for (let i = 0; i < nums.length; i ++) {
        map[nums[i]] = i;
    }
    
    for (let j = 0; j < nums.length; j ++) {
        let d = target - nums[j];
        if (map[d] && map[d] !== j) return [j, map[d]];
    }
    
    return [];
};

/**
 * 一遍map
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum2 = function(nums, target) {
    let map = {};
    
    for(let i = 0; i < nums.length; i++) {
        let d = target - nums[i];
        
        if (typeof map[d] !== 'undefined') return [map[d], i];
        
        map[nums[i]] = i; 
    }
    
    return [];
};