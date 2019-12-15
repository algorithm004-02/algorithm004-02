# https://leetcode-cn.com/problems/two-sum/submissions/

# 暴力法
# time complexity: O(N^2)
# space complexity: O(1)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []

# 两遍hash法
# time complexity: O(N)
# space complexity: O(N)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        data = {}
        for idx, i in enumerate(nums):
            data[i] = idx
        for idx, i in enumerate(nums):
            val = target - i
            if val in data and data[val] != idx:
                return [idx, data[val]]
        return []


# 一遍hash法
# time complexity: O(N)
# space complexity: O(N)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        data = {}
        for idx, i in enumerate(nums):
            val = target - i
            if val in data:
                return [data[val], idx]
            data[i] = idx
        return []

