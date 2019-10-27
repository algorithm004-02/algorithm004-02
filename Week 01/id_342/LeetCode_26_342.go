// 方法一： 复杂度  ->  O（n^2)
// 1. 两层for loop, 在第2层for loop中遇到重复的元素，就删除，同时结束本次loop
// 2. 重复上面的过程

// func removeDuplicates(nums []int) int {
// 	var l int = len(nums)
// 	var j int = 0
// 	for i:=0; i< l;{
// 		var count int = 0
// 		for j = i+1; j< l; {
// 			if nums[i] == nums[j] {
// 				j++
// 				count ++
// 			} else {
// 				break
// 			}
// 		}
// 		nums = append(nums[:i+1],nums[j:]...)
// 		l = l - count
// 		i++
// 		count = 0
// 	}
// 	return len(nums)
// }

// 方法2：复杂度 -> O(n)
func removeDuplicates(nums []int) int {
	var l int = len(nums)
	for i:=0; i< l-1;{
		if nums[i] == nums[i+1] {
			i++
			// nums = append(nums[:i],nums[i+2:]...)
		} else {
			break
		}
		nums = append(nums[:i],nums[i+2:]...)
		l = l - 1
	}
	fmt.Println(nums)
	return len(nums)
}
