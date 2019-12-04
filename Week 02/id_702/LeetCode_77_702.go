package leetcode

/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 */

// @lc code=start

func combine(n int, k int) [][]int {
	arr := make([]int, 0)
	for i := 1; i <= n; i++ {
		arr = append(arr, i)
	}

	result := make([][]int, 0)
	tmp := make([]int, 0)
	combinestackback(arr, &result, k, 0, tmp)
	return result
}

func combinestackback(arr []int, result *[][]int, k int, ind int, tmp []int) {
	if len(tmp) == k {
		//		fmt.Printf("tmp=%v, tmp addr is %p, ind=%d\n", tmp, tmp, ind)
		a := make([]int, k)
		// a = append(a, tmp...)
		copy(a, tmp)
		*result = append(*result, a)
		return
	}

	for i := ind; i < len(arr); i++ {
		tmp := append(tmp, arr[i])
		//		fmt.Printf("tmp=%v, tmpcap=%d, tmpaddr=%p, ind=%d, arr=%v \n", tmp, cap(tmp), tmp, ind, arr[i+1:])
		combinestackback(arr, result, k, i+1, tmp)
	}
}

// @lc code=end
