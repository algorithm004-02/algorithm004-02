package leetcode

/*
 * @lc app=leetcode.cn id=88 lang=golang
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
func merge(nums1 []int, m int, nums2 []int, n int) {
	// 最简单，最快
	// copy(nums1[m:], nums2)
	// sort.Ints(nums1)

	// 双指针
	p1, p2 := m-1, n-1
	for p3 := m + n - 1; p1 >= 0 && p2 >= 0; p3-- {
		if nums1[p1] < nums2[p2] {
			nums1[p3] = nums2[p2]
			p2--
		} else {
			nums1[p3] = nums1[p1]
			p1--
		}
	}
	copy(nums1[:p2+1], nums2)
}

// @lc code=end
