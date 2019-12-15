#
# @lc app=leetcode id=300 lang=python3
#
# [300] Longest Increasing Subsequence
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        ## dp without binary search O(n^2)
        # dp = [1] * n
        # for i in range(n):
        #     for j in range(i):
        #         if nums[i] > nums[j]:
        #             dp[i] = max(dp[i], dp[j] + 1)
        # return max(dp)

        # dp with binary search O(nlogn)
        if n < 2:
            return n
        tails = [0] * n
        end = 0
        tails[0] = nums[0]
        for i in range(1, n):
            if nums[i] > tails[end]:
                end += 1
                tails[end] = nums[i]
            else:
                left = 0
                right = end
                while left < right:
                    mid = left + ((right - left) >> 1)
                    if tails[mid] < nums[i]:
                        left = mid + 1
                    else:
                        right = mid
                tails[left] = nums[i]
        return end + 1

# @lc code=end

