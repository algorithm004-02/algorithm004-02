package id_432

func numDecodings(s string) int {
	//如果s最开始为0，返回0
	if s[0:1] == "0" {
		return 0
	}
	pre,cur := 1,1
	for i := 1;i < len(s) ; i++ {
		tmp := cur
		if s[i:i+1] == "0" {
			if s[i-1:i] == "1" || s[i-1:i] == "2" {
				cur = pre
			} else {
				return 0
			}
		} else if s[i-1:i] == "1" || (s[i-1:i] == "2" && s[i:i+1] >= "1" && s[i:i+1] <= "6") {
			cur = cur + pre
		}
		pre = tmp
	}
	return cur
}
