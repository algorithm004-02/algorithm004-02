package main

import "fmt"

func numDecodings(s string) int {
	if len(s) == 0 {
		return 0
	}
	var ans, count float64
	count, ans = 1, 1
	l, r, m := (1+math.Sqrt(5))/2, (1-math.Sqrt(5))/2, 1/math.Sqrt(5)
	for i := 0; i < len(s); i++ {
		if s[i] > '2' {
			tmp := (math.Pow(l, count-1)-math.Pow(r, count-1))*m + (math.Pow(l, count)-math.Pow(r, count))*m

			if s[i] >= '7' {
				if i != 0 && s[i-1] != '1' {
					tmp -= (math.Pow(l, count-1) - math.Pow(r, count-1)) * m

				}
			}
			ans = ans * tmp
			fmt.Println(ans)
			count = 1

		} else {
			if s[i] == '0' {
				ans = ans * ((math.Pow(l, count-1) - math.Pow(r, count-1)) * m)
				count = 1
			} else {
				count++
			}
		}
	}

	if count != 1 {
		ans = ans * (math.Pow(l, count) - math.Pow(r, count)) * m
	}
	return int(math.Floor(ans + 0.5))
}
