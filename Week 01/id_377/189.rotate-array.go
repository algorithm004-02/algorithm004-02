// @lc code=start
// ------------------------- 解法1 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
func rotate(nums []int, k int) {
	if len(nums) != 0 {
		copy(nums, append(nums[len(nums)-k%len(nums):], nums[0:len(nums)-k%len(nums)]...))
	}
}

// @lc code=end

