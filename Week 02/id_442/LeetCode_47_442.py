# https://leetcode-cn.com/problems/permutations-ii/submissions/

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result, used = [], [False] * len(nums)
        nums.sort()
        self._permuteUnique(nums, 0, [], used, result)
        return result

    def _permuteUnique(self, nums: List[int], level: int, items: List[int], used: List[bool], result: List[List[int]]):
        if level == len(nums):
            result.append(items[:])
            return
        for i in range(len(nums)):
            if not used[i]:
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                    continue
                used[i] = True
                items.append(nums[i])
                self._permuteUnique(nums, level + 1, items, used, result)
                items.pop()
                used[i] = False
