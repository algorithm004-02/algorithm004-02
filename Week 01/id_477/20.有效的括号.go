package leetcode

/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 */

// @lc code=start
func isValid(s string) bool {
	dic := map[rune]rune{'{': '}', '(': ')', '[': ']'}
	stack := []rune{}
	for _, c := range s {
		if _, ok := dic[c]; ok {
			stack = append(stack, c)
		} else {
			var sc rune
			if len(stack) == 0 {
				sc = '#'
			} else {
				sc = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
			if dic[sc] != c {
				return false
			}
		}
	}
	return len(stack) == 0
}

// @lc code=end
