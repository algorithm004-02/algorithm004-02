# https://leetcode-cn.com/problems/longest-increasing-subsequence/

# 动态规划
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        if size <= 1:
            return size
        dp = [1] * size
        for i in range(size):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
        return max(dp)

