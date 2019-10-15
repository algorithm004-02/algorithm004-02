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
