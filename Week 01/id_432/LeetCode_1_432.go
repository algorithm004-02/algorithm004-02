package id_432

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for k:=0;k<len(nums);k++{
		if b,ok := m[nums[k]];ok && b != k{
			return []int{b,k}
		}else{
			m[target - nums[k]] = k
		}
	}
	return nil
}
