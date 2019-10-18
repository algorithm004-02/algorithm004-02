
// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    if (nums.length === 0) {
        return 0;
    }
    let R = 0;
    for (let L = 0; L < nums.length; L++) { //从左开始循环
        if (nums[L] != nums[R]) { //如果非重复, 即，左边不等于右边,那么将左边复制到右边，然后递增R,重复本过程
            console.log('nums[L] != nums[R]',`${L}:${nums[L]}--${R}:${nums[R]}`);
            R++;
            nums[R] = nums[L];
        }else{ // 如果是重复项就跳过
            console.log('nums[L] == nums[R]',`${nums[L]}--${nums[R]}`);
        }
        console.log('nums 变化:---->',nums)
    }
    return R + 1;
}
// @lc code=end

console.log(
    '长度：', removeDuplicates([1,1,2,3])
);


// nums[L] == nums[R] 1--1
// nums 变化:----> [ 1, 1, 2, 3 ]
// nums[L] == nums[R] 1--1 
// nums 变化:----> [ 1, 1, 2, 3 ]
// nums[L] != nums[R] 2--1
// nums 变化:----> [ 1, 2, 2, 3 ]
// nums[L] != nums[R] 3--2
// nums 变化:----> [ 1, 2, 3, 3 ]
// 长度： 3



