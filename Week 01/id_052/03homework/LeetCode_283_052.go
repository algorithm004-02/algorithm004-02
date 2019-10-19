package leetcode

// 1. 构造新的数组
// 执行用时 : 88 ms, 在所有 golang 提交中击败了 96.14% 的用户
// 内存消耗 : 7.6 MB, 在所有 golang 提交中击败了 99.02% 的用户
func moveZeroes(nums []int) {
	arr := make([]int, 0) // 去除0的数组
	cnt := 0              // 记录0的个数
	// 1. 遍历数组记录0的个数，和去除0的数组
	for _, n := range nums {
		if n == 0 {
			cnt++
		} else {
			arr = append(arr, n)
		}
	}
	// 2. 在去除0的数组之后追加0
	for i := 0; i < cnt; i++ {
		arr = append(arr, 0)
	}
	// 3. 把arr赋值给nums
	for i := 0; i < len(nums); i++ {
		nums[i] = arr[i]
	}
}

// 2. 在数组中原地操作 时间复杂度O(n),空间复杂度O(1)
func moveZeroes2(nums []int) {
	index := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[index] = nums[i]
			index++
		}
	}

	for i := index; i < len(nums); i++ {
		nums[i] = 0
	}
}

// https://leetcode-cn.com/problems/move-zeroes/solution/custerxue-xi-bi-ji-shuang-zhi-zhen-by-custergo/
