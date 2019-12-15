package leetcode

/*
 * @lc app=leetcode.cn id=709 lang=golang
 *
 * [709] 转换成小写字母
 */

// @lc code=start
func toLowerCase(str string) string {
	b := make([]byte, len(str))
	bstr := []byte(str)
	for k, v := range bstr {
		if v >= 65 && v <= 90 {
			v = v + 32
		}
		b[k] = v
	}
	return string(b)
}

// @lc code=end
