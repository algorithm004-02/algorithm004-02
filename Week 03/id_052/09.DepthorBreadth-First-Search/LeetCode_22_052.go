package leetcode

// Catalan Number
// 回溯算法: Time: O(4^n / sqrt(n)), Space: O(n)
func generateParenthesis(n int) []string {
	if n <= 0 {
		return []string{}
	}
	var result []string
	generate(&result, "", n, n)
	return result
}

// result:保存结果,str:当前组合,left:剩余左括号数量right:剩余右括号数量
func generate(result *[]string, str string, left, right int) {
	if left == 0 && right == 0 { // 剩余左右括号都为0时
		*result = append(*result, str) // 当前组合即为合法排列加入结果
	} else {
		if left > 0 { // 还有剩余的左括号，就添加左括号，左括号并减少1
			generate(result, str+"(", left-1, right)
		}
		if right > left { // 剩余右括号比左括号多，就可以添加右括号
			generate(result, str+")", left, right-1)
		}
	}
}

// 动态规划: Time: O(4^n / n*sqrt(n)), Space: O(4^n / n*sqrt(n))
func generateParenthesisDP(n int) []string {
	if n <= 0 {
		return []string{}
	}
	dp := make([][]string, n+1) // 初始化列表dp
	for i := 0; i < n+1; i++ {
		dp = append(dp, []string{})
	}
	dp[0] = append(dp[0], "") // dp[0]只有一个空串
	for i := 1; i < n+1; i++ {
		for j := 0; j < i; j++ {
			for _, left := range dp[j] { // 从dp[j]和dp[i-j-1]中各拿一个
				for _, right := range dp[i-j-1] { // 合法排列left和right
					str := "(" + left + ")" + right // left左右加括号得到新的
					dp[i] = append(dp[i], str)      // 合法排列添加到dp[i]
				}
			}
		}
	}
	return dp[n]
}
