# https://leetcode-cn.com/problems/maximum-product-subarray/

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max_value = min_value = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0:
                max_value, min_value = min_value, max_value
            max_value = max(max_value * nums[i], nums[i])
            min_value = min(min_value * nums[i], nums[i])
            res = max(res, max_value)
        return res
