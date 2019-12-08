# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        slow = 0
        for i in range(1, len(nums)):
            if nums[slow] != nums[i]:
                slow += 1
                nums[slow] = nums[i]
        return slow + 1
