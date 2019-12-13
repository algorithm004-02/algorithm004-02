# https://leetcode.com/problems/two-sum/
# 1. Two Sum

# Approach 1: Brute Force
# time complexity O(n^2), space complexity O(1)
class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    for i in range(len(nums) - 1):
      for j in range(i + 1, len(nums)):
        if nums[i] + nums[j] == target:
          return [i, j]

# Approach 2: Hash Table
# time complexity O(n), space complexity O(n)
class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    hashMap = dict()
    for i, x in enumerate(nums):
      if target - x in hashMap:
        return [hashMap[target - x], i]
      hashMap[x] = i