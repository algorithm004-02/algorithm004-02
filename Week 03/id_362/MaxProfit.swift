class Solution {
    func maxProfile(_ prices: [Int]) -> Int {
        if prices.isEmpty { return 0 }
        var profit = 0
        for i in 1..<prices.count {
            var tmp = prices[i] - prices[i - 1]
            if tmp > 0 { profit += tmp }
        }
        return profit
    }
}
