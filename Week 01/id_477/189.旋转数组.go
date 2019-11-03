package leetcode

/*
 * @lc app=leetcode.cn id=189 lang=golang
 *
 * [189] 旋转数组
 */

// @lc code=start
func rotate(nums []int, k int) {
	//方法一：使用额外k个空间
	// if k = k % len(nums); k > 0 {
	// 	tmpArr := make([]int, 0, k)
	// 	for i := 0; i < len(nums); i++ {
	// 		if i < k {
	// 			tmpArr = append(tmpArr, nums[len(nums)-i-1])
	// 		} else {
	// 			nums[len(nums)-1-i+k] = nums[len(nums)-1-i]
	// 		}
	// 	}
	// 	for i := k - 1; i >= 0; i-- {
	// 		nums[k-i-1] = tmpArr[i]
	// 	}
	// }

	// 方法二：使用len(nums)个额外空间，简洁明了，推荐
	// lenght := len(nums)
	// new := make([]int, lenght)
	// for i := 0; i < lenght; i++ {
	// 	new[(i+k)%lenght] = nums[i]
	// }
	// copy(nums, new)

	// 方法三：反转法
	k = k % len(nums)
	reverseSlice(nums, 0, len(nums)-1)
	reverseSlice(nums, 0, k-1)
	reverseSlice(nums, k, len(nums)-1)
}

func reverseSlice(nums []int, i, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

// @lc code=end
