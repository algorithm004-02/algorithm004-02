
import java.util.Stack;

public class _042_trappingrainwater {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int trap = s1.trap(new int[] {3, 1, 2});
        System.out.println(trap);

        trap = s1.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);

        Solution3 s3 = new Solution3();
        trap = s3.trap_(new int[] {2, 0, 2});
        System.out.println(trap);

        Solution4 s4 = new Solution4();
        trap = s4.trap(new int[] {3, 1, 2});
        System.out.println(trap);

        trap = s4.trap(new int[]{2,0,2});
        System.out.println(trap);

        trap = s4.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);
    }
}

interface ISolution {
    int trap(int[] height);
}

/**
 * 按列求
 * time complexity : O(N^2)
 * space complexity : O(1)
 */
class Solution1 implements ISolution {
    @Override
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int total = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 左侧最高值
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > left) {
                    left = height[l];
                }
            }
            // 右侧最高值
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > right) {
                    right = height[r];
                }
            }
            // 找出左右短板并就计算
            int min = Math.min(left, right);
            if (min > height[i]) {
                total = total + (min - height[i]);
            }
            left = 0;
            right = 0;
        }
        return total;
    }
}

/**
 * DP求
 * 计算当前下标的left、right， 递推公式: left[i] = Max(left[i - 1], height[i])
 * time complexity : O(N)
 * space complexity : O(N)
 */
class Solution2 implements ISolution {
    @Override
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int l = 1; l <= height.length - 1; l++) {
            left[l] = Math.max(left[l - 1], height[l - 1]);
        }
        for (int r = height.length - 2; r >= 0; r--) {
            right[r] = Math.max(right[r + 1], height[r + 1]);
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                total = total + (min -height[i]);
            }
        }
        return total;
    }
}

/**
 * 双指针法，
 * 类似#11题; 另外在Solution2的基础上优化空间复杂度
 * time complexity : O(N)
 * space complexity : O(1)
 */
class Solution3 implements ISolution {
    // 减少一半空间使用
    int trap_(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int[] right = new int[height.length];
        for (int r = height.length - 2; r >= 0; r--) {
            right[r] = Math.max(right[r + 1], height[r + 1]);
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 状态压缩
            left = Math.max(left, height[i - 1]);

            int min = Math.min(left, right[i]);
            if (min > height[i]) {
                total = total + (min -height[i]);
            }
        }
        return total;
    }

    @Override
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int total = 0;
        int left = 1;
        int right = height.length - 2;
        int max_left = 0;
        int max_right = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 从左到右更新（类似于#11题）
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    total = total + (min - height[left]);
                }
                left++;
            } else { // 从右向左更新
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    total = total + (min - height[right]);
                }
                right--;
            }
        }
        return total;
    }
}

/**
 * 栈
 * 类似俄罗斯方块那样由下向上一层一层，填充，铺满就出栈了。
 * time complexity : O(N)
 * space complexity : O(N)
 */
class Solution4 implements ISolution {
    @Override
    public int trap(int[] height) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.peek()];
                stack.pop();
                if (stack.size() > 0) {
                    int distance = i - stack.peek() - 1;
                    int min = Math.min(height[stack.peek()], height[i]);
                    total = total + distance * (min - bottom);
                }
            }
            stack.push(i);
        }
        return total;
    }
}
