// https://leetcode-cn.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            // 弹出并计算。
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int previous = stack.pop();
                //排除相邻和连续一样
                if (stack.isEmpty() || height[stack.peek()] == 0) {
                    continue;
                }
                //计算积水增量
                int distance = (i - stack.peek() - 1);
                result += distance * (Math.min(height[i], height[stack.peek()]) - height[previous]);
            }
            stack.push(i);
        }
        return result;
    }
}