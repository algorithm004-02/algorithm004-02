#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            if target - nums[i] in nums[i+1:]:
                return [i, nums.index(target - nums[i], i+1)]
# @lc code=end