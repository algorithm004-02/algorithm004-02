package LeetCode

// 查找表
func twoSum(nums []int, target int) []int {
	record := make(map[int]int)
	for i, n := range nums {
		record[target-n] = i
	}

	for i, n := range nums {
		if v, ok := record[n]; ok && v != i {
			return []int{i, v}
		}
	}
	return []int{}
}
