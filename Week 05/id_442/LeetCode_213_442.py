# https://leetcode-cn.com/problems/house-robber-ii/

class Solution:
    def rob(self, nums: List[int]) -> int:
        def _rob(nums: List[int]):
            currentMax, prevMax = 0, 0
            for i in nums:
                currentMax, prevMax = max(prevMax + i, currentMax), currentMax
            return currentMax
        return max(_rob(nums[:-1]), _rob(nums[1:])) if len(nums) != 1 else nums[0]
