#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    
    def removeDuplicates(self, nums: List[int]) -> int:
        return list(filter(lambda x:nums.count(x) ==1, nums))

        
# @lc code=end

