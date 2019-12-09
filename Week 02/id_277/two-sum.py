class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for index, v in enumerate(nums):
            if target - v in dict:
                return [dict[target - v], index]
            dict[v] = index