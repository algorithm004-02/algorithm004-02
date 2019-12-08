# https://leetcode-cn.com/problems/subsets/solution/

# 递归
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self._subsets(result, nums, [], 0)
        return result

    def _subsets(self, result: List[List[int]], nums: List[int], items: List[int], level: int):
        if len(nums) == level:
            result.append(items[:])
            return
        self._subsets(result, nums, items, level + 1)
        items.append(nums[level])
        self._subsets(result, nums, items, level + 1)
        items.pop()

# 迭代
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for i in nums:
            result += [[i] + num for num in result]
        return result
