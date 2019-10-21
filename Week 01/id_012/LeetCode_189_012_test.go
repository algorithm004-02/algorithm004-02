package main

import (
	"testing"
)

/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* 示例 1:
* 输入: [1,2,3,4,5,6,7] 和 k = 3
* 输出: [5,6,7,1,2,3,4]
* 解释:
* 向右旋转 1 步: [7,1,2,3,4,5,6]
* 向右旋转 2 步: [6,7,1,2,3,4,5]
* 向右旋转 3 步: [5,6,7,1,2,3,4]
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/rotate-array
 */
func TestRotateArray(t *testing.T) {

}

/**
 * 抢座位法
 * a，b，c，d，e => a抢了c，c抢了e，e抢了b，b抢d，d抢了a 绕了一圈。
 * 1. 转换 K => k%len(nums)
 * 2. 记录移动元素的次数
 * 3. 临时记录初始变量 oldData
 * 4. 记录当前位置 current
 * 5. 记录要移动的位置 moveTo
 * 6. 终止条件：所有元素都移动了一遍
 *
 * 注意：
 * 第一个循环的写法
 */
func RotateArray(nums []int, k int) {
	l := len(nums)
	k = k % l
	count := 0
	for i := 0; count < l; i++ {
		var current, moveTo, tmp int
		current = i
		oldData := nums[i]
		for {
			moveTo = (current + k) % l
			tmp = nums[moveTo]
			nums[moveTo] = oldData
			oldData = tmp
			current = moveTo
			count++
			if i == moveTo {
				break
			}
		}
	}
}
