# 874. Walking Robot Simulation
# https://leetcode.com/problems/walking-robot-simulation/
class Solution:
  def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
    pos = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    obstacleSet = set(map(tuple, obstacles))
    x, y, di, res = 0, 0, 0, 0
    for c in commands:
      if c == -2: di = (di - 1) % 4
      elif c == -1: di = (di + 1) % 4
      else:
        dx, dy = pos[di]
        while c:
          if (x + dx, y + dy) not in obstacleSet:
            x += dx
            y += dy
          c -= 1
        res = max(res, x * x + y * y)
    return res