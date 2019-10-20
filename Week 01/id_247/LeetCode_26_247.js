/**
 * 26. 删除排序数组中的重复项 :
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ 简单
 * 1. 两次 for 循环， O(n^2), splice 删除重复的
 * 2. 一次 for 循环， O(n), splice 删除重复的
 * 3. 不删除，只是把重复的往后移
 */
const removeDuplicates = (nums) => {

    for (let i = 0; i < nums.length; i++) {

        for (let j = i + 1; j < nums.length; j++) {

            if (nums[i] === nums[j]){

                nums.splice(j, 1)
                j--
            }
        }
    }
    return nums.length
}

const removeDuplicates2 = (nums) => {

    let i = 0
    for (let j = 1; j < nums.length; j++) {

        if (nums[i] === nums[j]) {

            nums.splice(j, 1)
            j--
        }
        else
            i++
    }
    console.log( nums )
    return nums.length
}

const removeDuplicates3 = (nums) => {

    let i = 0
    for (let j = i + 1; j < nums.length; j++) {

        if (nums[i] !== nums[j]) {

            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}
