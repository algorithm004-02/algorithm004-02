package leetcode

import "bytes"

/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 */

// @lc code=start
func groupAnagrams(strs []string) [][]string {
	strMap := make(map[string][]string)
	ss := make([][]string, 0)
	for _, str := range strs {
		s := agramMap(str)
		strMap[s] = append(strMap[s], str)
	}
	for _, v := range strMap {
		ss = append(ss, v)
	}
	return ss
}

func agramMap(str string) string {
	var buffer bytes.Buffer
	arr := make([]int, 26)
	for _, ch := range str {
		arr[ch-'a']++
	}
	for _, v := range arr {
		buffer.WriteByte('#')
		buffer.WriteByte(byte(v))
	}
	return buffer.String()
}

// func agramMap(str string) string {
// var buffer bytes.Buffer
// arr := make([]int, 26)
// for _, ch := range str {
// arr[ch-'a']++
// }
// for k, v := range arr {
// if v != 0 {
// buffer.WriteByte(byte(k))
// buffer.WriteByte(byte(v))
// }
// }
// return buffer.String()
// }

// @lc code=end
