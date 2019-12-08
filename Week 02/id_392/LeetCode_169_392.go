package main

func majorityElement(nums []int) int {
	current, count := 0, 0
	for _, v := range nums {
		if count == 0 {
			current = v
			count++ // 计算当前的数字出现的次数
		} else if current == v {
			count++
		} else {
			count--
		}
	}
	return current

}
