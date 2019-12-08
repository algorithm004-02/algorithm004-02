/**
 * 189. 旋转数组： 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * https://leetcode-cn.com/problems/rotate-array/  简单

 * 1. API直接删除后面的，并把删除了的填充到顶部  60 ms , 在所有 javascript 提交中击败了 99.86% 的用户
 * 2. 暴力：每次移一个
 * 3. 利用余数做循环
 * 4. 反转
 */
const rotate = (nums, k) => {

    const rightRotat = nums.splice( nums.length - k, k)
    nums.unshift(...rightRotat)
    return nums
};


const rotate2 = (nums, k) => {

    let temp = 0
    let prev = 0
    const n = nums.length

    for (let i = 0; i < k; i++) {

        prev = nums[n - 1]

        for (let j = 0; j < n; j++) {   // 99,-100,3,99   99,-1,3,99   99,-1,-100,99   99,-1,-100,3

            temp = nums[j]
            nums[j] = prev
            prev = temp
        }
    }
    return nums
};


const rotate3 = (nums, k) => {

    const n = nums.length
    const arr = new Array(n)

    for (let i = 0; i < n; i++) {

        arr[ (i + k) % n] = nums[i]
    }
    nums = arr
    return nums
}


const reverse = (nums, start, end) => {

    while (start < end) {

        let temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}

const rotate4 = (nums, k) => {

    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.length - 1)
    return nums
}