package leetcode

// Time: O(n) Space: O(1)
func maxProfit(prices []int) int {
	if prices == nil || len(prices) == 0 {
		return 0
	}
	var (
		profit    int
		buyPrice  int
		sellPrice int
	)
	i := 0
	n := len(prices)

	for i < n-1 { // 不断查找波谷和波峰
		for i < n-1 && prices[i+1] <= prices[i] {
			i++ // 下一个数小于等于当前数，向后移动i
		}
		buyPrice = prices[i] // 波谷价格定义为买入价格
		for i < n-1 && prices[i+1] >= prices[i] {
			i++ // 下一个数大于等于当前数，向后移动i
		}
		sellPrice = prices[i]            // 波峰价格定义为卖出价格
		profit += (sellPrice - buyPrice) // 买入卖出利润加入到结果集
	}
	return profit // 循环结束后返回利润
}

// Time: O(n), Space: O(1)
func maxProfitGreedy(prices []int) int {
	if prices == nil || len(prices) == 0 {
		return 0 // 先处理边界
	}
	profit := 0 // 初始化利润为0
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] { // 若第i天价格大于前一天价格
			profit += prices[i] - prices[i-1] // 把差值作为利润加入到结果集
		}
	}
	return profit // 返回利润
}
