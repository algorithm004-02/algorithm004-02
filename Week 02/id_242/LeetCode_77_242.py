#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n <= 0 or k <= 0 or k > n:
            return []
        res = []
        self.backtrack(1, n, k, [], res)
        return res

    def backtrack(self, first: int, n: int, k: int, curlist: List[int], res: List[List[int]]):
        if len(curlist) == k:
            res.append(curlist[:])
            return
        # The upper limit of i meets:
        # n - i + 1 = k - len(curlist)
        # k - len(curlist) is the number of left numbers
        for i in range(first, n-(k-len(curlist)) + 2):
            curlist.append(i)
            self.backtrack(i+1, n, k, curlist, res)
            curlist.pop()

        
# @lc code=end

