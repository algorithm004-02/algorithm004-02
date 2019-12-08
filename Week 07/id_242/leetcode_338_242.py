#
# @lc app=leetcode id=338 lang=python3
#
# [338] Counting Bits
#

# @lc code=start
class Solution:
    def countBits(self, num: int) -> List[int]:
        #res = []
        # for i in range(0, num+1):
        #     res.append(self.countOneBits(i))
        # return res
        res = [0 for _ in range(num+1)]
        for i in range(1, num+1):
            if i & 1 == 0:
                res[i] = res[i >> 1]
            else:
                res[i] = res[i-1] + 1
        return res
    
    # def countOneBits(self, n: int) -> int:
    #     sum = 0
    #     while n != 0:
    #         sum += 1
    #         n = n & (n-1)
    #     return sum
        
# @lc code=end

