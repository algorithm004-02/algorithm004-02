package combine

func combine(n int, k int) [][]int {
	if n <= 0 || k == 0 {
		return [][]int{}
	}

	res := [][]int{}
	dfs(1, k, n, []int{}, &res)

	return res
}

func dfs(index, k, n int, arr []int, res *[][]int) {
	//terminator
	if len(arr) == k {
		tmp := make([]int, k)
		copy(tmp, arr)
		*res = append(*res, tmp)
		return
	}

	//process(split your big problem)
	//drill down(subproblems), merge(subsult)
	for i := index; i <= n; i++ {
		arr = append(arr, i)
		dfs(i+1, k, n, arr, res)
		arr = arr[:len(arr)-1]
	}
	//reverse current level state
}
