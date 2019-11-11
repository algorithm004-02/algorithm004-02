package id_432

import "sort"

func findContentChildren(g []int, s []int) int {
	if len(g) == 0 || len(s) == 0 {
		return 0
	}
	sort.Ints(g)
	sort.Ints(s)
	gindex := len(g) - 1
	sindex := len(s) - 1
	sgmax := 0
	for gindex >= 0 && sindex >= 0 {
		if s[sindex] < g[gindex] {
			gindex--
		} else {
			gindex--
			sindex--
			sgmax++
		}
	}
	return sgmax
}
