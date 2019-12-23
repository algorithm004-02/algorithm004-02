package leetcode

/*
 * @lc app=leetcode.cn id=387 lang=golang
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
func firstUniqChar(s string) int {
	dict := make(map[byte][]int)
	for i := range s {
		dict[s[i]] = append(dict[s[i]], i)
	}
	var res []int
	for _, v := range dict {
		if len(v) == 1 {
			res = append(res, v[0])
		}
	}
	if len(res) > 0 {
		min := res[0]
		for i := 1; i < len(res); i++ {
			if min > res[i] {
				min = res[i]
			}
		}
		return min
	}
	return -1
}

// @lc code=end
