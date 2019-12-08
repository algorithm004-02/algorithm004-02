class Solution:
    def moveZeroes(self, nums):
        """
        Do not return anything, 
        modify nums inplace instead.
        """
        slow = 0
        for fast in range(len(nums)):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow = 1