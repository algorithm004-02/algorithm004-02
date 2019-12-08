#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1

    # def removeDuplicates(self, nums: List[int]) -> int:
    #     if len(nums) == 0:
    #         return 0
    #     targetIndex, OG = 1, nums[0]
    #     for i in range(1, len(nums)):
    #         if nums[i] != OG:
    #             OG = nums[i]
    #             nums[targetIndex] = nums[i]
    #             targetIndex += 1
    #     return targetIndex

        
# @lc code=end

