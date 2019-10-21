// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
// 暴力
class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = heights[i];
                for (int k = i+1; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                area = Math.max(area, minHeight * (j-i+1));
            }
        }
        return area;
    }
}

// 栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                // 执行出入栈计算面积
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}