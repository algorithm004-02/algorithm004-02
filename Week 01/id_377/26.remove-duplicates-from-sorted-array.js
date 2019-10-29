// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    if (nums.length === 0) {
        return 0;
    }

    // ------------------------- 解法1 start --------------------------
    // 最好记  👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    // let i = 0;
    // for (let j = 0; j < nums.length; j++) {
    //     if (nums[j] != nums[i]) 
    //         nums[++i] = nums[j];
    // }
    // return ++i;

    // ------------------------- 解法2 start--------------------------
    // 最好记  👍 👍 👍 👍 
    // 最优解  😘 😘 😘 😘 😘
    // for (i = 0; i < nums.length; i++) {
    //     if (nums[i] == nums[i+1]) {
    //         nums.splice(i, 1);
    //         i--;
    //     }
    // }

    // ------------------------- 解法3 start--------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘
    // nums.splice(0, nums.length, ...(new Set(nums)));

    // ------------------------- 解法4 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    // 双指针解法有趣的记忆方法
    // 背景：父亲和儿子去菜园摘菜，儿子拿篮子， 父亲需要找到3种不同的菜，每找到一种，就招呼儿子前来，父亲把菜放在篮子里。
    let c= 0;  // 儿子的篮子里一个菜也没有;
    for (let f = 0; f < nums.length; f++) { // 父亲的手上一棵菜也没有，父亲一步一步去摘菜。
        if (nums[c] !== nums[f]) { // 如果父亲摘到的菜和篮子里的菜不一样，或者空篮子的情况下。
            c++; // 儿子往前走一步。
            nums[c] = nums[f]; // 父亲把菜放到儿子的篮子里
        }
    }
    return c+1; // 返回儿子的步数, 儿子从0步开始走，所以加1. 
};
// @lc code=end

console.log(
    removeDuplicates([1, 1, 2])
);
