#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (44.64%)
# Likes:    12165
# Dislikes: 425
# Total Accepted:    2.2M
# Total Submissions: 5M
# Testcase Example:  '[2,7,11,15]\n9'
#
# Given an array of integers, return indices of the two numbers such that they
# add up to a specific target.
# 
# You may assume that each input would have exactly one solution, and you may
# not use the same element twice.
# 
# Example:
# 
# 
# Given nums = [2, 7, 11, 15], target = 9,
# 
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
# 
# 
#

# @lc code=start
class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     for i in range(len(nums) - 1):
    #         for j in range(i+1,len(nums)):
    #             if nums[i] + nums[j] == target:
    #                 return i, j
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i in range(len(nums)):
            dict[nums[i]] = i

        for i in range(len(nums)):
            j = dict.get(target - nums[i])
            if j and i != j:
                return i, j
        
# @lc code=end

