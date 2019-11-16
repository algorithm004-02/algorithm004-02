#
# @lc app=leetcode id=874 lang=python3
#
# [874] Walking Robot Simulation
#

# @lc code=start
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        x, y = 0, 0
        dir_index = 0
        ans = 0
        block_set = set(map(tuple, obstacles))
        for command in commands:
            if command == -2:
                dir_index = (dir_index - 1) % 4
            elif command == -1:
                dir_index = (dir_index + 1) % 4
            else:
                for j in range(command):
                    if (x + dx[dir_index], y + dy[dir_index]) not in block_set:
                        x += dx[dir_index]
                        y += dy[dir_index]
                        ans = max(ans, x*x + y*y)
        return ans

# @lc code=end

