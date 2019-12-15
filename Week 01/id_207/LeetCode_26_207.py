# remove-duplicates-from-sorted-array
# 删除排序数组中的重复项
# 1、暴力
# 2、双指针
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        j = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                nums[j] = nums[i]
                j += 1
        return j
