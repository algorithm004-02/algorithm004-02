#
# @lc app=leetcode.cn id=45 lang=python3
#
# [45] 跳跃游戏 II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        end, maxposition, steps = 0, 0, 0
        for i in range(len(nums) - 1):
            maxposition = max(maxposition, i + nums[i])
            if i == end:
                end = maxposition
                steps += 1
        return steps
        
        

        
# @lc code=end

