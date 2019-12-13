# https://leetcode-cn.com/problems/trapping-rain-water/

from collections import deque

class Solution:
    def trap(self, height: List[int]) -> int:
        total = 0
        stack = deque(maxlen=len(height))
        for current in range(len(height)):
            while len(stack) != 0 and height[current] > height[stack[-1]]:
                h = height[stack.pop()]
                if len(stack) == 0:
                    break
                distance = current - stack[-1] - 1
                m = min(height[current], height[stack[-1]])
                total += distance * (m - h)
            stack.append(current)
        return total
