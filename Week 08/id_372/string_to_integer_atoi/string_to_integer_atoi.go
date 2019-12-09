package string_to_integer_atoi

import "math"

func myAtoi(str string) int {
	index, sign, res := 0, 1, 0
	if len(str) == 0 {
		return 0
	}

	for index < len(str) && str[index] == ' ' {
		index++
	}

	if index < len(str) && (str[index] == '-' || str[index] == '+') {
		if str[index] == '-' {
			sign = -1
		}
		index++
	}

	for index < len(str) {
		digit := int(str[index] - '0')
		if digit < 0 || digit > 9 {
			break
		}
		if math.MaxInt32/10 < res || (math.MaxInt32/10 == res && math.MaxInt32%10 < digit) {
			if sign == 1 {
				return math.MaxInt32
			}
			return math.MinInt32
		}

		res = 10*res + digit
		index++
	}

	return res * sign
}
