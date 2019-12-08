/** 55. 跳跃游戏  */

/**
 * 时间复杂度为O(2^n) 空间复杂度为O(n)
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    return dfs(0);
    
    function dfs(posi) {
        if (posi >= nums.length - 1) return true;

        let end = posi + Math.min(nums[posi], nums.length - 1);
        for(let start = posi + 1; start <= end; end--) {
            if (dfs(end)) return true;
        }

        return false;
    }
};

/**
 * 时间复杂度为O(n^2) 空间复杂度O(n)
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump2 = function(nums) {
    let memMap = nums.map((num,index) => false);
    memMap[nums.length - 1] = true;
    
    return dfs(0);
    
    function dfs(posi) {
        if (posi >= nums.length) return false;
        
        if (memMap[posi]) return true;
        
        let end = posi + Math.min(nums[posi], nums.length);
        for(let start = posi + 1; start <= end; start ++) {
            if (dfs(start)) return memMap[memMap] = true;
        }
        
        return false;
    }
};

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump3 = function(nums) {
    let len = nums.length;
    let last = len - 1;
    let j = len - 2;
    
    for (; j >= 0; j --) {
        if (j + nums[j] >= last) last = j;
    }
    
    return last <= 0;
};

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump4 = function(nums) {
    let tmpMax = 0;
    for (let i = 0; i < nums.length; i ++) {
        if (i > tmpMax) return false;
        tmpMax = Math.max(tmpMax, i + nums[i]);
    }
    
    return true;
};