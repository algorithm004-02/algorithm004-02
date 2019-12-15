package leetcode

/*
 * @lc app=leetcode.cn id=387 lang=golang
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start

func firstUniqChar(s string) int {
	hash := make([]int, 26)
	for _, c := range s {
		hash[c-'a']++
	}
	for i, c := range s {
		if hash[c-'a'] == 1 {
			return i
		}
	}
	return -1
}

// too slow !!!!!
//func firstUniqChar(s string) int {
//	res := -1
//	bs := []byte(s)
//	m := make(map[byte]int)
//	for k := range bs {
//		if _, ok := m[bs[k]]; ok {
//			bs[m[bs[k]]] = '#'
//			bs[k] = '#'
//		}
//		m[bs[k]] = k
//	}
//	for k := range bs {
//		if bs[k] != '#' {
//			res = k
//			break
//		}
//	}
//	return res
//}

// @lc code=end
