package leetcode

/*
 * @lc app=leetcode.cn id=17 lang=golang
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
func letterCombinations(digits string) []string {
	if digits == "" {
		return nil
	}
	m := make(map[rune]string)
	digstr := make([]string, 0)
	result := make([]string, 0)
	m['2'] = "abc"
	m['3'] = "def"
	m['4'] = "ghi"
	m['5'] = "jkl"
	m['6'] = "mno"
	m['7'] = "pqrs"
	m['8'] = "tuv"
	m['9'] = "wxyz"
	for _, v := range []rune(digits) {
		digstr = append(digstr, m[v])
	}
	lcstackback(&result, digstr, 0, "")
	return result
}

func lcstackback(str *[]string, digstr []string, ind int, tmp string) {
	if ind == len(digstr) {
		*str = append(*str, tmp)
		return
	}
	for i := 0; i < len(digstr[ind]); i++ {
		lcstackback(str, digstr, ind+1, tmp+string(digstr[ind][i]))
	}
}

// @lc code=end
