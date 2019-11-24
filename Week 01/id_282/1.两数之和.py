#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i,x in enumerate(nums) :
            temp=nums[:i]
            if target-x in temp:
                j = temp.index(target -x)
                return [i,j]
# @lc code=end

