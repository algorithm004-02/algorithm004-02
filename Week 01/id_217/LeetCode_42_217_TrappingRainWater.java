public class TrappingRainWater {
    public Solution solution = new Solution();

    class Solution {
        public int trap(int[] height) {
            if (height.length <= 0) return 0;
            int result = 0;
            int leftMax = 0, rightMax = 0;
            int left = 0, right = height.length - 1;

            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];

                    } else {
                        result += (leftMax - height[left]);
                    }
                    left++;
                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];

                    } else {
                        result += (rightMax - height[right]);
                    }
                    right--;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = (new TrappingRainWater()).solution;
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
