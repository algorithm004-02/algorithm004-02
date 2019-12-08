package assign_cookies

import "sort"

func findContentChildren(g []int, s []int) int {
	if len(g) == 0 || len(s) == 0 {
		return 0
	}
	//排序
	sort.Ints(g)
	sort.Ints(s)
	count := 0
	//使用贪心匹配
	for i, j := 0, 0; i < len(g)-1 && j < len(s)-1; {
		if g[i] > s[j] {
			j++
			continue
		}

		j++
		i++
		count++
	}

	return count
}
