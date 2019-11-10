package main

func maxProfit(prices []int) int {
	earn := 0
	buy := false
	n := len(prices)
	var start int
	for i := 0; i < n; i++ {
		if !buy && i < n-1 && prices[i+1] < prices[i] {
			continue
		}
		if !buy {
			buy = true
			start = prices[i]
			continue
		}
		if buy && ((i < n-1 && prices[i+1] < prices[i]) || (i == n-1)) {
			buy = false
			earn += prices[i] - start
			continue
		}
	}
	return earn
}
