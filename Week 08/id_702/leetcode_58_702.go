package leetcode

/*
 * @lc app=leetcode.cn id=58 lang=golang
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
func lengthOfLastWord(s string) int {
	count := 0
	flag := 0
	b := []byte(s)
	l := len(s)
	for i := l - 1; i >= 0; i-- {
		if b[i] == 32 {
			if flag != 0 {
				return count
			}
			continue
		}
		flag++
		count++
	}
	return count
}

// @lc code=end
