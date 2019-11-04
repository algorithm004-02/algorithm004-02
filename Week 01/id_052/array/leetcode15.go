package LeetCode

import "sort"

// Using Hash Table to store all the numbers
// Time Complexity: O(n^2) Space Complexity: O(n)
func threeSum1(nums []int) [][]int {
	var res [][]int
	counter := make(map[int]int)
	for _, value := range nums {
		counter[value]++
	}

	var uniqNums []int // Remove duplications
	for key := range counter {
		uniqNums = append(uniqNums, key)
	}
	sort.Ints(uniqNums)

	for i := 0; i < len(uniqNums); i++ {
		if uniqNums[i]*3 == 0 && counter[uniqNums[i]] >= 3 {
			res = append(res, []int{0, 0, 0})
		}
		for j := i + 1; j < len(uniqNums); j++ {
			if uniqNums[i]*2+uniqNums[j] == 0 && counter[uniqNums[i]] >= 2 {
				res = append(res, []int{uniqNums[i], uniqNums[i], uniqNums[j]})
			}
			if uniqNums[i]+uniqNums[j]*2 == 0 && counter[uniqNums[j]] >= 2 {
				res = append(res, []int{uniqNums[i], uniqNums[j], uniqNums[j]})
			}
			c := 0 - uniqNums[i] - uniqNums[j]
			if c > uniqNums[j] && counter[c] > 0 {
				res = append(res, []int{uniqNums[i], uniqNums[j], c})
			}
		}
	}
	return res
}

// Using two pointers technique
// Time Complexity: O(n^2) Space Complexity: O(n)
func threeSum2(nums []int) [][]int {
	sort.Ints(nums)
	var res [][]int
	index := 0
	for index < len(nums) {
		if nums[index] > 0 {
			break
		}
		bindex, cindex := index+1, len(nums)-1
		for bindex < cindex {
			if nums[bindex]+nums[cindex] == -nums[index] {
				res = append(res, []int{nums[index], nums[bindex], nums[cindex]})
				// continue to look for other pairs
				bindex = nex_num_index(nums, bindex)
				cindex = pre_num_index(nums, cindex)
			} else if nums[bindex]+nums[cindex] < -nums[index] {
				bindex = nex_num_index(nums, bindex)
			} else { // nums[bindex] + nums[cindex] > -nums[index]
				cindex = pre_num_index(nums, cindex)
			}
		}
		index = nex_num_index(nums, index)
	}
	return res
}

func nex_num_index(nums []int, cur int) int {
	for i := cur + 1; i < len(nums); i++ {
		if nums[i] != nums[cur] {
			return i
		}
	}
	return len(nums)
}

func pre_num_index(nums []int, cur int) int {
	for i := cur - 1; i >= 0; i-- {
		if nums[i] != nums[cur] {
			return i
		}
	}
	return -1
}

// 超出时间限制 Time Complexity: O(n^3) Space Complexity: O(n)
func threeSum3(nums []int) [][]int {
	var res [][]int              // 定义要返回的结果
	set := make(map[[3]int]bool) // 定义集合set去重三元组
	sort.Ints(nums)              // 排序数组

	for i := 0; i < len(nums)-2; i++ { // 使用三重for循环
		for j := i + 1; j < len(nums)-1; j++ {
			for k := j + 1; k < len(nums); k++ {
				if nums[i]+nums[j]+nums[k] == 0 { // 取出任意三个数字相加等于0
					elem := [3]int{nums[i], nums[j], nums[k]} // 组成三元组
					if ok, _ := set[elem]; ok {               // 集合里是否已经包含这个三元组
						continue // 如果包含着返回继续
					}
					set[elem] = true           // 否则往集合里添加三元组
					res = append(res, elem[:]) // 将该三元组添加到结果中
				}
			}
		}
	}
	return res // 循环结束后返回结果
}

// Time Complexity: O(n^2) Space Complexity: O(1)
func threeSum4(nums []int) [][]int {
	var res [][]int // 定义要返回的结果
	sort.Ints(nums) // 排序数组

	for k := len(nums) - 1; k >= 2; k-- { // k从数组尾部开始遍历
		if nums[k] < 0 { // 如果k指向的数字已经小于0则跳出循环
			break
		}
		i, j, target := 0, k-1, -nums[k] // 定义目标target和游标i, j
		for i < j {
			if nums[i]+nums[j] == target { // 两数之和等于目标值
				res = append(res, []int{nums[i], nums[j], nums[k]})
				for i < j && nums[i+1] == nums[i] {
					i++
				} // 跳过重复的元素
				for i < j && nums[j-1] == nums[j] {
					j--
				} // 跳过重复的元素
				i, j = i+1, j-1
			} else if nums[i]+nums[j] < target {
				i++
			} else {
				j--
			}
		}
		for k >= 2 && nums[k-1] == nums[k] { // 对于k也要跳过相同的数字
			k--
		}
	}
	return res // 循环结束返回结果
}
