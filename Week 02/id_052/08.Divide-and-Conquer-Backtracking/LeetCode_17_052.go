package leetcode

// Time: O(n^4), Space: O(n)
func letterCombinations(digits string) []string {
	if digits == "" || len(digits) == 0 {
		return []string{}
	}
	var result []string
	combinations(digits, 0, "", result)
	return result
}

// 辅助递归函数digits:输入字符串,idx:当前考察的位置下标,str:中间结果
func combinations(digits string, idx int, str string, result []string) {
	mapping := []string{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

	if idx == len(digits) { // 下标达到字符串长度
		result = append(result, str) // 说明str就是合法的字符组合
		return
	}
	chars := mapping[digits[idx]-'2'] // 否则把数字下标为idx取出减去字符2
	for _, c := range chars {         // 遍历chars依次取出字母,加到中间结果str
		combinations(digits, idx+1, str+string(c), result)
	} // 递归调用自己去处理idx+1的位置
}

// 迭代 Time: O(4^n), Space: O(4^n)
func letterCombinationsInterative(digits string) []string {
	if digits == "" || len(digits) == 0 {
		return []string{}
	}
	mapping := []string{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
	var res []string
	res = append(res, "") // 往结果队列中加入一个空字符串
	for i := 0; i < len(digits); i++ {
		chars := mapping[digits[i]-'2'] // 取出数字字符对应的字母
		size := len(res)                // 当前队列大小取出
		for j := 0; j < size; j++ {
			str := res[0] // 取出头部元素
			res = res[1:] // 弹出头部元素
			for k := 0; k < len(chars); k++ {
				// 从chars中取出当前字符的可选字母
				res = append(res, str+string(chars[k]))
			}
		}
	}
	return res
}
