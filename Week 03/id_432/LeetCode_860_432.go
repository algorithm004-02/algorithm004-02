package id_432

func lemonadeChange(bills []int) bool {
	remain5 := 0
	remain10 := 0
	for _, bill := range bills {
		if bill == 5 {
			remain5++
		} else if bill == 10 {
			if remain5 <= 0 {
				return false
			} else {
				remain5--
				remain10++
			}
		} else {
			if remain10 >= 1 && remain5 >= 1 {
				remain10--
				remain5--
			} else if remain5 >= 3 {
				remain5 = remain5 - 3
			} else {
				return false
			}
		}
	}
	return true
}
