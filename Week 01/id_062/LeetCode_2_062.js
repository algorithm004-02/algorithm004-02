/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*
* */

/*
暴力解法
* */
function rotate(nums, k) {
    let temp, previous
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1]
        for (let j = 0; j < nums.length; j++) {
            temp = nums[j]
            nums[j] = previous
            previous = tmp
        }
    }

}

