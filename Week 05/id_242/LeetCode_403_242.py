#
# @lc app=leetcode id=403 lang=python3
#
# [403] Frog Jump
#

# @lc code=start
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if not stones or stones[0] != 0 or (len(stones) > 1 and stones[1] != 1):
            return False
        jump_map = {}
        for stone in stones:
            jump_map[stone] = set()
        jump_map[0].add(0)
        for stone in stones:
            for k in jump_map[stone]:
                for step in range(k-1, k+2):
                    if step > 0 and (stone + step) in jump_map:
                        jump_map[stone + step].add(step)
        return len(jump_map[stones[-1]]) > 0
        
# @lc code=end

