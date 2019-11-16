#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        output = []
        def recursion(currint, currList):
            if len(currList) == k:
                return output.append(currList[:])
            for i in range(currint , n + 1):
                currList.append(i)
                recursion(i+1 , currList)
                currList.pop()
        recursion(1, [])
        return output
        
# @lc code=end

