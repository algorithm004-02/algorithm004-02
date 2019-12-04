import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start

//Solution 1: Two pointer
// class Solution {
//     public int trap(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int leftMax = 0;
//         int rightMax = 0;
//         int result = 0;
//         while (left <= right) {

//             if (height[left] < height[right]) {
//                 if (height[left] >= leftMax)
//                     leftMax = height[left];
//                 else
//                     result += leftMax - height[left];
//                 left++;
//             } else {
//                 if (height[right] >= rightMax)
//                     rightMax = height[right];
//                 else
//                     result += rightMax - height[right];
//                 right--;
//             }

//         }
//         return result;

//     }
// }

//Solution 2: Stack

class Solution {

    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxWater = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int bot = stack.pop();
                int maxBotWater = stack.isEmpty() ? 0
                        : (Math.min(height[stack.peek()], height[i]) - height[bot]) * (i - stack.peek() - 1);
                maxWater += maxBotWater;
            }
        }

        return maxWater;
    }
}
// @lc code=end
