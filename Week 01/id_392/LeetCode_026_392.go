package main

func remove(nums []int) int {
	var tmp int
	for i := 1; i < len(nums); i++ {
		tmp = nums[i-1]
		if tmp == nums[i] {
			nums = append(nums[:i], nums[i+1:]...)
			i--
		}
	}
	return len(nums)
}

func main() {
	var nums = []int{1, 1, 2}
	var k = removeDuplicates(nums)
	fmt.Printf("num: %d, array: %v\n", k, nums)
}
