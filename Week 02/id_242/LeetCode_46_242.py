#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        res = []
        self.backtrack(0, len(nums), nums, res)
        return res

    def backtrack(self, first: int, n: int, nums: List[int], res: List[List[int]]):
        if first == n:
            res.append(nums[:])
        for i in range(first, n):
            nums[first], nums[i] = nums[i], nums[first]
            self.backtrack(first+1, n, nums, res)
            nums[first], nums[i] = nums[i], nums[first]
        
# @lc code=end

