from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return 1
        i = 1
        temp = nums[0]
        while i < len(nums):
            if nums[i] == temp:
                nums.pop(i)
                continue
            temp = nums[i]
            i += 1
        print(nums)
        return len(nums)
