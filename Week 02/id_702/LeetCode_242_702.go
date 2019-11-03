package leetcode

/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
//func isAnagram(s string, t string) bool {
//	if len(s) != len(t) {
//		return false
//	}
//	ms := make(map[rune]int)
//	mt := make(map[rune]int)
//	for _, v := range s {
//		ms[v]++
//	}
//
//	for _, v := range t {
//		mt[v]++
//	}
//
//	for k := range ms {
//		if ms[k] == mt[k] {
//			continue
//		} else {
//			return false
//		}
//	}
//	return true
//}
//func isAnagram(s string, t string) bool {
//	m := make(map[rune]int)
//	for _, v := range s {
//		m[v]++
//	}
//	for _, v := range t {
//		m[v]--
//	}
//
//	for _, v := range m {
//		if v != 0 {
//			return false
//		}
//	}
//
//	return true
//}
func isAnagram(s string, t string) bool {
	arr := make([]int, 26)
	for _, ch := range []rune(s) {
		arr[ch-'a']++
	}

	for _, ch := range []rune(t) {
		arr[ch-'a']--
	}
	for _, v := range arr {
		if v != 0 {
			return false
		}
	}
	return true
}

// @lc code=end
