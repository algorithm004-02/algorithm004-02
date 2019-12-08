"""
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    """
    方法一、暴力法遍历，找某个柱子左右两边的最大值
         边界从1，n-1查询，因为左边界和右边界都没有值
    """
    def trap(self, height: List[int]) -> int:
        ans = 0
        
        for i in range(1, len(height)-1):
            max_left = 0
            max_right = 0
            
            for j in range(i, -1, -1):
                max_left = max(max_left, height[j])
            for j in range(i, len(height)):
                max_right = max(max_right, height[j])
            
            ans += min(max_left, max_right) - height[i]
        return ans

    """
    方法二、 用栈实现
       step1: 栈为空时，则下标值入栈
       step2: 栈不为空时，判断当前的值是否大于栈顶，如果小于，说明未找到长板，把当前下标入栈
              如果当前的值大于栈顶，则栈顶元素出栈，判断栈是否为空，如果为空，则说明需要左边
              边界为空，需要重新建立左边边界，否则计算当前的高度，以此类推
        核心思想：栈底保存左边界，当前值判断是否为右边界
    """
    def trap_2(self, height: List[int]) -> int:
        ans = 0
        stack = []
        i = 0
        
        while i < len(height):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                if not stack:
                    break
                distance = i - stack[-1] -1
                bounded_height = min(height[i], height[stack[-1]]) - height[top]
                ans += distance * bounded_height
            stack.append(i)
            # print(stack, height[stack[0]], height[i])
            i += 1
        return ans

    def trap_3(self, height: List[int]) -> int:
        # 记得判断数组为空的情况
        if not height: return 0
        # 尝试双指针法
        max_left = 0
        max_right = 0
        
        i = 0
        j = len(height) - 1
        ans = 0
        
        while i != j:
            if height[i] < height[j]:
                if max_left <= height[i]:
                    max_left = height[i]
                else:
                    ans += max_left - height[i]
                i += 1
            else:
                if max_right <= height[j]:
                    max_right = height[j]
                else:
                    ans += max_right - height[j]
                j -= 1
                
        return ans