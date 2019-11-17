/*
 * @lc app=leetcode.cn id=860 lang=golang
 *
 * [860] 柠檬水找零
 */

// @lc code=start
func lemonadeChange(bills []int) bool {
	c5 := 0
	c10 := 0
	for i := 0; i < len(bills); i++ {
		switch bills[i] {
		case 5:
			c5++
		case 10:
			c10++
			c5--
			if c5 < 0 {
				return false
			}
		case 20:
			c5--
			if c10 > 0 {
				c10--
			} else {
				c5 -= 2
			}
			if c10 < 0 || c5 < 0 {
				return false
			}
		}
	}
	return true
}

// @lc code=end
