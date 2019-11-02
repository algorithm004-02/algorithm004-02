class Solution:
    def trap(self, height: List[int]) -> int:
        _sum = 0
        stack = []
        current = 0
        while current < len(height):
            while stack and height[current] > height[stack[-1]]:
                h = height[stack[-1]]
                stack.pop()
                if not stack:
                    break
                distance = current - stack[-1] - 1
                _min = min(height[stack[-1]], height[current])
                _sum = _sum + distance * (_min -h)
            stack.append(current)
            current += 1
        return _sum
