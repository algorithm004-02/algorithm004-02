# https://leetcode.com/problems/trapping-rain-water/
# 42. Trapping Rain Water

# Approach 1: Brute force
# time complexity: O(n^2), space complexity: O(1)
class Solution:
  def trap(self, height: List[int]) -> int:
    result = 0
    for i in range(1, len(height) - 1):
      l = r = 0
      for j in range(i, -1, -1):
        l = max(l, height[j])
      for k in range(i, len(height)):
        r = max(r, height[k])
      result += min(l, r) - height[i]
    return result

# Approach 2: Using stacks
# time complexity: O(n), space complexity: O(n)
class Solution:
  def trap(self, height: List[int]) -> int:
    result = 0
    stack = []
    for i in range(len(height)):
      while stack and height[i] > height[stack[-1]]:
        top = stack[-1]
        stack.pop()
        if not stack: break
        distance = i - stack[-1] - 1
        bounded_height = min(height[i], height[stack[-1]]) - height[top]
        result += distance * bounded_height
      stack.append(i)
    return result

# Approach 3: Using 2 pointers
# time complexity: O(n), space complexity: O(1)
class Solution:
  def trap(self, height: List[int]) -> int:
    l, r, res = 0, len(height) - 1, 0
    lMax = rMax = 0
    while l <= r:
      if height[l] < height[r]:
        res += max(lMax-height[l], 0)
        lMax = max(lMax, height[l])
        l += 1
      else:
        res += max(rMax-height[r], 0)
        rMax = max(rMax, height[r])
        r -= 1
    return res