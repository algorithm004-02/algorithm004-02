package leetcode

// Time: O(2^n), Space: O(n)
func subsets(nums []int) [][]int {
	if nums == nil || len(nums) == 0 {
		return [][]int{} // 处理边界
	}
	var res [][]int // 定义结果集合
	var elem []int  // 定义当前组合
	subsetsRec(nums, 0, elem, &res)
	return res
}

// nums:输入整数数组,start:开始下标,elem:当前数字组合,result:结果集合
func subsetsRec(nums []int, start int, elem []int, result *[][]int) {
	tmp := make([]int, len(elem))
	copy(tmp, elem) // 当前数组组合加入到结果集合
	*result = append(*result, tmp)
	// 因为遍历数字过程中产生的所有数字组合
	// 从下标start开始遍历数组
	for i := start; i < len(nums); i++ {
		// 取出一个数字加入到当前组合
		elem = append(elem, nums[i])
		// 递归调用自己,不能重复使用数字，下一轮递归从i+1开始
		subsetsRec(nums, i+1, elem, result)
		// 递归结束后把当前加入的数字移除
		elem = elem[:len(elem)-1]
	}
}
