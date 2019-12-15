# https://leetcode-cn.com/problems/house-robber/

# 动态规划 二维空间
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # dp[i][0] = max(dp[i-1][0], dp[i-1][1]): 第i天没偷累计金额
        # dp[i][1] = dp[i-1][0] + nums[i]: 第i天偷了累计金额
        # result = max(dp[-1][0], dp[-1][1])

        dp = [[0] * 2 for _ in range(len(nums))]
        for i in range(len(nums)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[-1][0], dp[-1][1])

# 动态规划 一维空间
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        # dp[i] = max(第i-1天偷了累计金额, 第i-2天没偷累计金额+第i天要偷的金额)
        # result = dp[-1]
        dp = [0] * (len(nums) + 1)
        dp[1] = nums[0]
        for i in range(2, len(nums) + 1):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])
        return dp[-1]


# 动态规划 O(1)空间复杂度
class Solution:
    def rob(self, nums: List[int]) -> int:
        prev_max, cur_max = 0, 0
        for num in nums:
            cur_max, prev_max = max(prev_max + num, cur_max), cur_max
        return cur_max


