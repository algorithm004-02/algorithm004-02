package main

func countSubstrings(s string) int {
	size := len(s)
	if size <= 1 {
		return size
	}

	dp := make([][]bool, size)
	count := size

	for i := 0; i < size; i++ {
		dp[i] = make([]bool, size)
		dp[i][i] = true

		if i < size-1 && s[i] == s[i+1] {
			dp[i][i+1] = true
			count++
		}
	}

	for slen := 3; slen <= size; slen++ {
		for i := 0; i < size-slen+1; i++ {
			j := i + slen - 1
			if s[i] == s[j] && dp[i+1][j-1] {
				dp[i][j] = true
				count++
			}
		}
	}
	return count
}
