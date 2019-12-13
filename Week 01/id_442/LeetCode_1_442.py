# https://leetcode-cn.com/problems/two-sum/submissions/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 暴力法
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 一遍hash法
        data = {}
        for idx, i in enumerate(nums):
            j = target - i
            if j in data:
                return [data[j], idx]
            data[i] = idx
        return []
