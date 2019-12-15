package leetcode

/*
 * @lc app=leetcode.cn id=1143 lang=golang
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
func longestCommonSubsequence(text1 string, text2 string) int {
	dp := make([][1000]int, len(text1)+1)
	t1 := []byte(text1)
	t2 := []byte(text2)
	for i := 1; i <= len(text1); i++ {
		for j := 1; j <= len(text2); j++ {
			if t1[i-1] == t2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = compmax(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[len(text1)][len(text2)]
}

func compmax(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

// @lc code=end
