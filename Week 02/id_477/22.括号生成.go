package leetcode

/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] 括号生成
 */

// @lc code=start
func generateParenthesis(n int) []string {
	res := make([]string, 0)
	generate(&res, 0, 0, n, "")
	return res
}

func generate(res *[]string, l, r, max int, s string) {
	// recursion terminer
	if l == max && r == max {
		*res = append(*res, s)
		return
	}
	// process current logical

	// drill down
	if l < max {
		generate(res, l+1, r, max, s+"(")
	}
	if r < l {
		generate(res, l, r+1, max, s+")")
	}
	// reverse status
}

// @lc code=end

// an example to understand this solution:
// (
// ((
// (((
// ((()
// ((())
// ((()))
// (()
// (()(
// (()()
// (()())
// (())
// (())(
// (())()
// ()
// ()(
// ()((
// ()(()
// ()(())
// ()()
// ()()(
// ()()()
