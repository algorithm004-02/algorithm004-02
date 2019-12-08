from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        obj = {}
        for i, num in enumerate(nums):
            obj[num] = i
        for d, n in enumerate(nums):
            j = obj.get(target - n)
            if j is not None and j != d:
                return [d, j]


nums = [2, 7, 11, 15]
s = Solution()
print(s.twoSum(nums, 9))
