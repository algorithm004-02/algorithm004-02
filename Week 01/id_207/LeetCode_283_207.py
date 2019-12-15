# LeetCode 283 MoveZeroes

# class Solution:
    # def moveZeroes(self, nums: List[int]) -> None:
def moveZeroes(nums):
    """
    Do not return anything, modify nums in-place instead.
    """

    i = j = 0

    for i in range(len(nums)):
        if (nums[i] != 0):
            nums[j], nums[i] = nums[i], nums[j]
            j += 1
    return nums

nums1 = [2, 0, 1, 2, 0, 12, 0]
print(moveZeroes(nums1))