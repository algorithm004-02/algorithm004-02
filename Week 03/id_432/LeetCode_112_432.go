package id_432

func maxProfit(prices []int) int {
	max := 0

	lens := len(prices) - 1
	for i := 0; i < lens;i++ {
		remain := prices[i + 1] - prices[i]
		if remain > 0 {
			max += remain
		}
	}
	return max
}
