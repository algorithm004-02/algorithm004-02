package com.itliusir.array;

import com.itliusir.util.PrintArrayUtil;

/**
 * problem.11
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * @author liugang
 * @since 2019/10/18
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(new MaxArea().maxAreaTwo(height));
    }

    /**
     * method 1 -> O(n^2)
     * 枚举暴力求解
     *
     * @author liugang 2019/10/18 16:44
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * method 2 -> O(n)
     * 左右向中收敛方法
     *
     * @author liugang 2019/10/18 18:16
     * */
    public int maxAreaTwo(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
