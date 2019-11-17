class Solution:
    def maxSubArray(self,nums):
        dp=nums
        for i in range(1,len(nums)):
            dp[i]=nums[i]+max(0,dp[i-1])
        return max(dp)