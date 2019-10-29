package id_432

func plusOne(digits []int) []int {
	num := 0
	for i := len(digits) - 1; i >= 0 ; i-- {
		if i == len(digits) - 1 {
			if digits[i] + 1 >= 10 {
				digits[i] = 0
				num = 1
			} else {
				digits[i]++
				num = 0
			}
		} else {
			if digits[i] + num >= 10 {
				digits[i] = 0
				num = 1
			} else {
				digits[i] = digits[i] + num
				num = 0
			}
		}
	}
	//fmt.Println(digits,num)
	if num != 0 {
		digits[0] = 0
		digits = append([]int{1},digits...)
	}
	return digits
}
