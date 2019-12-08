// 方法三： 
// 使用map
func twoSum(nums []int, target int)  []int{
	var m map[int]int
	m = make(map[int]int)

	var res []int = []int{}

	for i,v := range nums {
		temp := target -v
		if _,ok := m[v]; ok{
			res = append(res,m[v],i)
		}

		m[temp] = i
	}

	return res
}
