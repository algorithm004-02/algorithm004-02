package main

func rotate(nums []int, k int) {
	k %= len(nums)
	tmp := append(nums[len(nums)-k:], nums[:len(nums)-k]...)
	nums = append(nums[:0], tmp...)
}

func main() {
	var nums = []int{1, 2, 3, 4, 5, 6, 7}
	var k = 3
	rotate(nums, 3)
	fmt.Println(nums)
}
