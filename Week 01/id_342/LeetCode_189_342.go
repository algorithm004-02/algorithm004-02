// 第一种方法, 复杂度-> O（n）
// func rotate(nums []int, k int) {
//     nums = nums[:]
// 	var l int = len(nums)
// 	for i := 1; i <=k; i++ {
// 		var index int = l - 1
// 		nums = append(nums[index:],nums[:index]...)
// 		// fmt.Printf("i= %d, %v\n", i,nums)
// 	}
// }

// 第二种方法, 复杂度 -> O(n^2)
// for loop ，在第二层loop里，每个元素都与最后一个元素交换位置
// func rotate(nums []int, k int) {
// 	var l int = len(nums)
// 	for i := 1; i<=k; i++ {
// 		for j := 0; j<l-1; j++ {
// 			nums[j],nums[l-1] = nums[l-1],nums[j]
// 		}
// 	}
// }

// 第三种方法： 复杂度 -> O(n)
// [1,2,3,4,5,6,7] 3
// 1. 先将  567 与123换位，得到 [5,6,7,4,1,2,3]
// 2. 先将 后半断 4 1 2 3 for loop，相邻两个之间换位
func rotate(nums []int, k int) {
	var l int = len(nums)
	if k > l {
		k = l
	}

	if k == 0 {
		nums = nums
	}
	for i:=0; i< k;i++{
		nums[i],nums[l-k+i] =  nums[l-k+i],nums[i]
	}
	fmt.Println(nums)
	for j := k; j < l - 1; j++ {
		nums[j],nums[j+1] = nums[j+1],nums[j]
	}
	fmt.Println(nums)
}
