# https://leetcode.com/problems/remove-duplicates-from-sorted-array/
# 26. Remove Duplicates from Sorted Array    

class Solution:
  def removeDuplicates(self, nums: List[int]) -> int:
    if not nums: return 0
    j = 0
    for i in range(1, len(nums)):
      if nums[i] != nums[j]:
        j += 1
        nums[j] = nums[i]
    return j + 1