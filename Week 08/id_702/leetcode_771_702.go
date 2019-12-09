package leetcode

/*
 * @lc app=leetcode.cn id=771 lang=golang
 *
 * [771] 宝石与石头
 */

// @lc code=start
func numJewelsInStones(J string, S string) int {
	m := make(map[byte]struct{})
	bS := []byte(S)
	count := 0
	for _, v := range []byte(J) {
		m[v] = struct{}{}
	}
	for k := range bS {
		if _, ok := m[bS[k]]; ok {
			count++
		}
	}
	return count
}

// @lc code=end
