# https://leetcode.com/problems/move-zeroes/
# 283. Move Zeroes

# time complexity O(n), space complexity O(n)
class Solution:
  def moveZeroes(self, nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    if not nums: return []

    queue = []
    j = 0

    for i in range(len(nums)):
      if nums[i] == 0:
        j += 1
      else:
        queue.append(nums[i])
        
    while j:
      j -= 1
      queue.append(0)
    
    for i in range(len(nums)):
      nums[i] = queue[i]
      
    return nums

# time complexity O(n), space complexity O(1)
class Solution:
  def moveZeroes(self, nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    if not nums: return []

    j = 0

    for i in range(len(nums)):
      if nums[i] != 0:
        nums[j] = nums[i]
        j += 1

    for i in range(j, len(nums)):
      nums[i] = 0

    return nums

# time complexity O(n), space complexity O(1)
# optimize zero writes
class Solution:
  def moveZeroes(self, nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    if not nums: return []

    j = 0

    for i in range(len(nums)):
      if nums[i] != 0:
        nums[j] = nums[i]
        if i != j:
          nums[i] = 0
        j += 1

    return nums