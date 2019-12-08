# 153. Find Minimum in Rotated Sorted Array
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
# apporach 1: binary search
class Solution:
  def findMin(self, nums: List[int]) -> int:
    if len(nums) == 1: return nums[0]
    l, r = 0, len(nums) - 1
    if nums[r] > nums[l]: return nums[l]
    while l <= r:
      m = l + (r - l) // 2
      if nums[m] > nums[m + 1]: return nums[m + 1]
      if nums[m] < nums[m - 1]: return nums[m]
      if nums[m] > nums[0]:
        l = m + 1
      else:
        r = m -1

# optimized
class Solution:
  def findMin(self, nums: List[int]) -> int:
    l, r = 0, len(nums) - 1
    while l < r:
      m = l + (r - l) // 2
      if nums[m] < nums[r]:
        r = m
      else:
        l = m + 1
    return nums[l]