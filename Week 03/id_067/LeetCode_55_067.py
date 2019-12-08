#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#

# @lc code=start
class Solution:
    #从后往前逐个跳
    def canJump(self, nums: List[int]) -> bool:
        lastPoint = len(nums) - 1
        for i in range(len(nums)-2, -1, -1):
            if i + nums[i] >= lastPoint:
                lastPoint = i
        #print(lastPoint)
        return lastPoint == 0
"""从前往后逐个跳
    def canJump(self, nums: List[int]) -> bool:
        flag = 0
        for i in range(len(nums)):
            if i > flag:
                return False
            flag = max(flag, i + nums[i])
        return True
"""
        
# @lc code=end

