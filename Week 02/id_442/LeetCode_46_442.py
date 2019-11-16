# https://leetcode-cn.com/problems/permutations/submissions/

from typing import List, Set

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        self._permute(nums, 0, [], set(), result)
        return result

    def _permute(self, nums: List[int], level: int, items: List[int], used: Set[int], result: List[List[int]]):
        if level == len(nums):
            result.append(items[:])
            return
        for i in range(len(nums)):
            if nums[i] not in used:
                used.add(nums[i])
                items.append(nums[i])
                self._permute(nums, level + 1, items, used, result)
                items.pop()
                used.remove(nums[i])
