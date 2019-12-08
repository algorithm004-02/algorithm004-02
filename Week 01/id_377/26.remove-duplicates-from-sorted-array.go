// @lc code=start
func removeDuplicates(nums []int) int {
	nlen := len(nums)
	if nlen == 0 {
		return 0
	}

	// ------------------------- 解法1 start --------------------------
	// 双指针位移,若不相等, out长度即为去重数组长度
	// 最好记  👍 👍 👍 👍 👍
	// 最优解  😘 😘 😘 😘 😘
	out := 1
	for i := 1; i < len(nums); i++ {
		if nums[i-1] != nums[i] {
			nums[out] = nums[i]
			out++
		}
	}
	return out

	// ------------------------- 解法2 start --------------------------
	// 最好记  👍 👍 👍
	// 最优解  😘 😘 😘 😘 😘
	// curIdx, prev := 0, nums[0]
	// for i := 1; i < nlen; i++ {
	// 	if nums[i] != prev {
	// 		curIdx++
	// 		nums[curIdx] = nums[i]
	// 		prev = nums[i]
	// 	}
	// }
	// return curIdx + 1

}

// @lc code=end

