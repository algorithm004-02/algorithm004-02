package leetcode

func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for _, b := range bills {
		if b == 5 {
			five++
		} else if b == 10 {
			five, ten = five-1, ten+1
		} else if ten > 0 {
			five, ten = five-1, ten-1
		} else {
			five -= 3
		}
		if five < 0 {
			return false
		}
	}
	return true
}
