package LeetCode

// 双指针法
// 时间复杂度：O(n)，假设数组的长度是n，那么k和i分别最多遍历n步
// 空间复杂度：O(1)
func removeDuplicates(nums []int) int {
	k := 0                           // k 是慢指针
	for i := 1; i < len(nums); i++ { // i 是快指针
		if nums[i] != nums[k] { // 不重复的值赋值给nums[k+1]
			k++
			nums[k] = nums[i]
		} // 重复的值将跳过
	}
	return k + 1
}
