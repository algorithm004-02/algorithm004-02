
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    //暴力解法    
    //时间复杂度O(n^2)  空间复杂度O(1)
    // var arr;
    // for(var i=0; i<nums.length-1; i++){
    //     for(var j = i+1; j<nums.length; j++){
    //         if(nums[j] == target - nums[i] ) return arr = [i,j];
    //     }
    // }
    
    //利用Map映射的查找O(1)
    //时间复杂度O(n)  空间复杂度O(n)
    let memory = new Map();
    for(let i = 0; i< nums.length; i++) {
        //存在逆的的就 就获取坐标
        if(memory.has(target - nums[i])) {
            return [memory.get(target - nums[i]),i];
        }else {
        //不存在就加入
            memory.set(nums[i],i);
        }
    }
    
};