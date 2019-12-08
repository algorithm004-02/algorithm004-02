package leetcode

// Time: O(n), Space: O(1)
func nextPermutation(nums []int) {
	if nums == nil || len(nums) < 2 {
		return // 数组为空或数组元素少于2个直接返回无需处理
	}
	n := len(nums) // 赋值数组长度
	p := n - 2     // 定义游标p从n-2开始
	for p >= 0 && nums[p] >= nums[p+1] {
		p-- // 从左向右递减就不断向左移动p
	}
	if p >= 0 { // 说明在数组中找到了nums[p]<nums[p+1]
		i := n - 1 // 定义游标i从n-1开始
		for i > p && nums[i] <= nums[p] {
			i-- // 找到第一个比nums[p]大的数字
		} // 把该数字与nums[p]交换
		nums[i], nums[p] = nums[p], nums[i]
	} // 由于p+1到数组结尾是递减的，两两交换，翻转
	for i, j := p+1, n-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
