package main

//hash 法
func majorityElement(nums []int) int {
	lens := len(nums) / 2
	mapNums := make(map[int]int)
	for _,n := range nums {
		if _,ok := mapNums[n]; ok {
			mapNums[n]++
		} else {
			mapNums[n] = 1
		}
	}
	var res = -1
	for i,m := range mapNums {
		if m > lens {
			res =  i
			break
		}
	}
	return res
}