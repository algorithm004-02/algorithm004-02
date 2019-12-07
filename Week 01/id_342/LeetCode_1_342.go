// 方法一： 暴力法 -> O(n^2)
// func twoSum(nums []int, target int) []int {
//     var j int = 0
//     var arr []int = []int{}
//     arr = arr[:]
//     for i := 0; i < len(nums); i++ {
//         for j = i+1; j < len(nums); j++ {
//             if nums[i] + nums[j] == target {
//                 arr = append(arr,i,j)
//                 // fmt.Printf("%d,%d\n",nums[i],nums[j])
//             }
//         }
//     }
//     return arr
// }

// 方法二：  复杂度 -> 0(n)
// for loop一次。从两端往中间逼进
// 1. 在排序之前，深copy一份数据，nums2
// 2. 对排序之后的数据nums执行查找，找到两个值，
// 3. 在nums中查找这两个值的索引

func twoSum(nums []int, target int) []int {

	var nums2 []int = []int{}
	nums2 = append(nums2,nums...)
	sort.Ints(nums)
	var j int = len(nums) - 1
	var arr []int = []int{}
	var res []int = []int{}
	var sum int = 0
	for i := 0; i < j; {
		sum = nums[i] + nums[j]
		if sum < target {
			//fmt.Printf("sum < target : %d\n", i)
			i++
		} else if sum > target {
			//fmt.Printf("sum > target : %d\n", j)
			j--
		} else if sum == target {
			//fmt.Printf("sum == target : %d,%d\n", i,j)
			arr = append(arr,nums[i],nums[j])
			break

		}
	}
 	//fmt.Printf("arr: %v\n",arr)
 	//fmt.Printf("nums: %v\n",nums)
 	//fmt.Printf("nums2: %v\n",nums2)

	for i,v := range nums2 {
		if v == arr[0] || v == arr[1] {
			res = append(res, i)
		}
	}
	return res
}
