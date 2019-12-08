package main.java.com.fans.algorithm00402.week1.homework;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class LeetCode_42_232 {

    public static void main(String[] args) {
        LeetCode_42_232 code = new LeetCode_42_232();
        System.out.println(code.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // 1. 双指针法，往中间移
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left ++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right --;
            }
        }
        return sum;
    }
}
