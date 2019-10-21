class Solution:
    def trap(self, height: List[int]) -> int:
        left_temp_max = [0 for i in range(len(height))]  
        left_max = 0
        right_max = 0
        for i in range(len(height)):
            if height[i] > left_max: 
                left_max = height[i]
            left_temp_max[i] = left_max

        total = 0
        for i in range(len(height)-1, -1, -1):
            if height[i] > right_max: 
                right_max = height[i]
            if min(right_max, left_temp_max[i]) > height[i]:  
                total += min(right_max, left_temp_max[i]) - height[i]
        return total