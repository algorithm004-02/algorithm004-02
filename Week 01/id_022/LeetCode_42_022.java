//[42]接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

import java.util.LinkedList;

public class TrappingRainWater {

    /**
     * 有序栈法
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[stack.peek()], height[i]) - h) * (i - stack.peek() - 1);
                }
            }

            stack.push(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int[] case1 = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int value1 = trappingRainWater.trap1(case1);
        if (value1 != 6) {
            throw new AssertionError("case1");
        }

        int[] case2 = new int[] {1,2,3,2,1};
        int value2 = trappingRainWater.trap1(case2);
        if (value2 != 0) {
            throw new AssertionError("case2");
        }

        int[] case3 = new int[0];
        int value3 = trappingRainWater.trap1(case3);
        if (value3 != 0) {
            throw new AssertionError("case3");
        }
    }
}