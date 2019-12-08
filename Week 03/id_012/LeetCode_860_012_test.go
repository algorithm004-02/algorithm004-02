package main

import "testing"

func TestLemonadeChange(t *testing.T) {
	input := []int{5, 5, 5, 5, 10, 10, 5}
	t.Log(lemonadeChange(input))
}

func lemonadeChange(bills []int) bool {
	c5 := 0
	c10 := 0
	c20 := 0
	for _, v := range bills {
		switch v {
		case 5:
			c5++
		case 10:
			c10++
			c5--
			if c5 < 0 {
				return false
			}
		case 20:
			c20++
			if c10 > 0 {
				c10--
				c5--
			} else {
				c5 = c5 - 3
			}
			if c5 < 0 || c10 < 0 {
				return false
			}
		}
	}
	return true
}
