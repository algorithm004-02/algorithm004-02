class Solution {
    func lengthOfLIS(_ nums: [Int]) -> Int {
        if nums.isEmpty { return 0 }
        var dp = [Int](repeating: 1, count: nums.count) 
        var result = dp[0]
        for i in 0..<nums.count {
            for j in 0..<i {
                if nums[j] < nums[i] {
                    dp[i] = max(dp[i], dp[j] + 1)
                    result = max(dp[i], result)
                }
            }
        }
        return result
    }
}
