// 递归解法
class Solution {
    func rob(_ nums: [Int]) -> Int {
        if nums.isEmpty { return 0 }
        let robThis = (nums.first ?? 0) + rob(Array(nums.dropFirst(2)))
        let robNext = rob(Array(nums.dropFirst()))
        return max(robThis, robNext)
    }
}

// 动态规划
class Solution {
    func rob(_ nums: [Int]) -> Int {
        if nums.isEmpty { return 0 }
        if nums.count == 1 { return nums[0] }
        let count = nums.count
        var dp = [Int](repeating: 0, count: count + 1)
        dp[0] = 0
        dp[1] = nums[0]
        for i in 2...count {
            dp[i] = max(dp[i - 2] + nums[i - 1], dp[i - 1])
        }
        return dp[count]
    }
}
