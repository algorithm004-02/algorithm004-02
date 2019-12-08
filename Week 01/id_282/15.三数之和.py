#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        for i,x in enumerate(nums):
            temp=nums[:i]
            for j, y in enumerate(temp):
               z = - (y+x)
               temp2 = nums[:j]
               if z in temp2:
                   result.append([x,y,z])
        return result               

# @lc code=end

