class Solution:
    def maxArea(self, height: List[int]) -> int:
        # 除开暴力解法，这道题直接看了官方解法以及证明
        # 以下是看完后的实现
        # 感觉重点在于证明为何此种解法奏效，而并非此种解法的实现
        length = len(height) - 1
        
        i = 0
        j = length
        
        max_area = 0
        while length >= 1:
            area = min(height[i], height[j]) * length
            
            if area > max_area:
                max_area = area
                
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
            
            length -= 1
        
        return max_area
