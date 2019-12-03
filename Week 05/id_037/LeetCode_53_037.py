# https://leetcode-cn.com/problems/maximum-subarray/
# 分治： problem(i) = max(0, subproblem(i-1)) + a[i]
# 状态数组 dp[i]
# DP : dp[i] = max(0, dp[i-1]) + dp[i]
# todo
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = nums
        for num in xrange(len(nums) - 1, -1, -1):
            dp[i] = max(0, dp[i-1]) + nums[i]
        return dp[0]

# reference from leetcode 国际站             
class Solution:
    def maxSubArray(self, A):
        if not A:
            return 0

        curSum = maxSum = A[0]
        for num in A[1:]:
            curSum = max(num, curSum + num)
            maxSum = max(maxSum, curSum)

        return maxSum
        