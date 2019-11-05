#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(nums, [], res)
        return res

    def dfs(self, nums, path, res):
        if not nums:
            res.append(path)
        for i in range(len(nums)):
           # print(('i={}'.format(i))+('nums={}').format(nums[:i]+nums[i+1:])+('path={}').format(path+[nums[i]]))
            self.dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)
        
# @lc code=end

