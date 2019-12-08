package leetcode

import "math"

// Time: O(n), Space: O(1)
func canJump(nums []int) bool {
	if nums == nil || len(nums) == 0 {
		return false // 处理边界
	}
	n, max := len(nums), 0 // 定义max最远可以跳到的下标
	for i := 0; i < n; i++ {
		if max >= n-1 { // 最远可达下标已经大于等于n-1
			return true // 提前返回true
		}
		if i > max { // 若当前下标i已超出了最远可达下标
			return false // 提前返回false
		} // 若不是上面两种情况，就更新max最远可达下标
		max = int(math.Max(float64(max), float64(i+nums[i])))
	}
	return false // 循环结束后还没有提前返回就返回false
}
