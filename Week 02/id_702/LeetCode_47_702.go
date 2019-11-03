package leetcode

/*
 * @lc app=leetcode.cn id=47 lang=golang
 *
 * [47] 全排列 II
 */

// @lc code=start
func permuteUnique(nums []int) [][]int {
	if nums == nil {
		return nil
	}
	result := make([][]int, 0)
	permutestackback(&result, nums, 0)
	return result
}

func permutestackback(result *[][]int, nums []int, ind int) {
	if ind == len(nums) {
		tmp := make([]int, len(nums))
		copy(tmp, nums)
		*result = append(*result, tmp)
		return
	}

	m := map[int]int{}
	for i := ind; i < len(nums); i++ {
		if _, ok := m[nums[i]]; ok {
			continue
		}
		nums[i], nums[ind] = nums[ind], nums[i]
		permutestackback(result, nums, ind+1)
		nums[i], nums[ind] = nums[ind], nums[i]
		m[nums[i]]++
	}
}

//func permuteUnique(nums []int) [][]int {
//	result := [][]int{}
//	cur := []int{}
//	sort.Ints(nums) //!!
//	visited := make([]bool, len(nums))
//	//
//	dfs(&nums, &cur, &visited, &result)
//	return result
//}
//
//func dfs(nums, cur *[]int, visited *[]bool, result *[][]int) {
//	//edge
//	if len(*cur) == len(*nums) {
//		newRecord := make([]int, len(*cur))
//		copy(newRecord, *cur)
//		*result = append(*result, newRecord)
//	}
//
//	//for each num try
//	for i := 0; i < len(*nums); i++ {
//		v := (*nums)[i]
//		if (*visited)[i] == false {
//
//			if i > 0 && (*nums)[i] == (*nums)[i-1] && !(*visited)[i-1] { //!important
//				continue
//			}
//			(*visited)[i] = true
//			*cur = append(*cur, v)
//			dfs(nums, cur, visited, result)
//			*cur = (*cur)[:len(*cur)-1]
//			(*visited)[i] = false
//		}
//	}
//	// remove this try value
//}

// @lc code=end
