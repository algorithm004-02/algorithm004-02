package leetcode

import "sort"

////////// HashSet Version //////////
// 数组有重复元素，需要额外处理
// 在回溯法求解全排列的基础上，添加了一个 map 重复，回溯法经典的思想，
// 每次递归中维护一个 map 来检查是否在此阶段将两个相同的数交换了位置，若交换了则必定有所重复。
// Time: O(n*n!), Space: O(n)
func permuteUnique(nums []int) [][]int {
	if nums == nil || len(nums) == 0 {
		return [][]int{}
	}
	var result [][]int
	permuteRecSet(nums, 0, &result)
	return result
}

func permuteRecSet(nums []int, start int, result *[][]int) {
	if start == len(nums) {
		tmp := make([]int, len(nums))
		copy(tmp, nums)
		*result = append(*result, tmp)
	} else {
		var m map[int]int
		for i := start; i < len(nums); i++ {
			if _, ok := m[nums[i]]; ok {
				continue
			}
			nums[i], nums[start] = nums[start], nums[i]
			permuteRecSet(nums, start+1, result)
			nums[i], nums[start] = nums[start], nums[i]
			m[nums[i]] = 1
		}
	}
}

////////// Counter Version //////////
// Time: O(n*n!), Space: O(n)
func permuteUniqueCounter(nums []int) [][]int {
	if nums == nil || len(nums) == 0 {
		return [][]int{} // 处理边界
	}
	counter := make(map[int]int) // 定义hash表
	for _, num := range nums {   // 遍历数组统计每个数字出现次数
		counter[num]++
	}
	var res [][]int // 定义结果列表
	var list []int  // 定义辅助列表，用于记录当前的排列
	// 调用辅助递归函数，得到结果列表
	permuteRecCounter(list, len(nums), &res, counter)
	return res
}

// list: 记录当前排列,n: 凑够一个排列所需的元素个数,result:结果集,counter:记录每个数字和对应个数
func permuteRecCounter(list []int, n int, result *[][]int, counter map[int]int) {
	if n <= 0 { // 如果所需的元素个数n<=0
		tmp := make([]int, len(list))
		copy(tmp, list)                // 表示已经凑齐一个排列
		*result = append(*result, tmp) // 加入结果列表
	} else { // 否则遍历hash表中的元素
		for k, v := range counter {
			cnt := v      // 数字出现次数
			if cnt <= 0 { // 表示该数字已经使用完
				continue // 取下一个数字
			}
			list = append(list, k) // 把该数字的键值加入list
			counter[k] = cnt - 1   // 同时把该数字数量-1进行更新
			// 递归调用自己进行下一轮取数操作，凑齐一个排列所需元素个数-1
			permuteRecCounter(list, n-1, result, counter)
			counter[k] = cnt          // 递归调用结束后把当前数字的数量复原
			list = list[:len(list)-1] // 并把该数字从list中移除
		}
	}
}

////////// NextPermutation Version //////////
// Time: O(n*n!), Space: O(1)
func permuteUniqueNextPermutation(nums []int) [][]int {
	if nums == nil || len(nums) == 0 {
		return [][]int{}
	}
	var res [][]int         // 定义结果列表
	sort.Ints(nums)         // 把数组进行排序，得到最小的排列
	res = append(res, nums) // 把最小排列加入结果列表
	for nextPermute(nums) { // 存在下一个更大的排列leetcode-31
		tmp := make([]int, len(nums))
		copy(tmp, nums)
		res = append(res, tmp) // 加入结果列表
	}
	return res // 返回结果列表
}

func nextPermute(nums []int) bool {
	n := len(nums) // 赋值数组长度
	p := n - 2     // 定义游标p从n-2开始
	for p >= 0 && nums[p] >= nums[p+1] {
		p-- // 从左向右递减就不断向左移动p
	}
	if p >= 0 { // 说明在数组中找到了nums[p]<nums[p+1]
		i := n - 1 // 定义游标i从n-1开始
		for i > p && nums[i] <= nums[p] {
			i-- // 找到第一个比nums[p]大的数字
		} // 把该数字与nums[p]交换
		nums[i], nums[p] = nums[p], nums[i]
	} // 由于p+1到数组结尾是递减的，两两交换，翻转
	for i, j := p+1, n-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
	return p != -1
}
