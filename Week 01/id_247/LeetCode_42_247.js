/**
 * 42. 接雨水
  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/ 困难
 *
 * 双指针，计算高度差
 */

const trap = ( heights ) => {

    let left = 0
    let right = heights.length - 1
    let left_max = 0
    let right_max = 0
    let sum = 0

    while (left < right) {

        if (heights[left] < heights[right]) {

            heights[left] > left_max ? (left_max = heights[left]) : sum += (left_max - heights[left])
            left++
        }
        else {
            heights[right] > right_max ? (right_max = heights[right]) : sum += (right_max - heights[right])
            right--
        }
    }

    return sum
}