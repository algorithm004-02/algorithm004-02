#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return False
        numsdict = {}
        for i in range( 0, len(nums)):
            if (nums[i] in numsdict) and (i != numsdict[nums[i]]):
                #print(numsdict)
                return [ numsdict[nums[i]] , i] 
            else:
                numsdict[ target - nums[i]] = i
                #print(numsdict)
        

        
# @lc code=end

