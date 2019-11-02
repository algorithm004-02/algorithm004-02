/*** 169. 求众数 ***/

/**
 * 1. 暴力破解法
 * 时间复杂度O(n^2) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let maxCount = nums.length / 2;
    
    for (n of nums) {
        let count = 0;

        for (l of nums) {
            if (l === n) {
                count ++;
            }
        }
        
        if (count > maxCount) {
            return n;
        }
    }
};

/**
 * 2. 哈希表
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement2 = function(nums) {
    let map = {};
    let maxC = nums.length / 2;
    for (n of nums) {
        !map[n] ? (map[n] = 1) : ++ map[n]
        if(map[n] > maxC)  return n;
    }
}

/**
 * 分治回溯 
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    return majorityRec(0, nums.length - 1);
    
    function majorityRec (lo, hi) {
        // 终止条件
        if (lo === hi) return nums[lo];
        
        //process
        let mid = Math.floor((hi - lo) / 2) + lo;
        let left = majorityRec(lo, mid);
        let right = majorityRec(mid + 1, hi);
        if (left === right) return left;
        
        let leftC = 0, rightC = 0;
        for (let i = lo; i <= hi; i++ ) {
            (nums[i] === left) && leftC ++;
            (nums[i] === right) && rightC ++;
        }
        
        return leftC > rightC ? left : right;
    }
};