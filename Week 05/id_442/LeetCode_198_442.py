# https://leetcode-cn.com/problems/house-robber/

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [[0, 0] for _ in range(n)]

        dp[0][0] = 0
        dp[0][1] = nums[0]

        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[n-1][0], dp[n-1][1])


class Solution:
    def rob(self, nums: List[int]) -> int:
        prev_max, current_max = 0, 0
        for i in nums:
            current_max, prev_max = max(prev_max + i, current_max), current_max
        return current_max

