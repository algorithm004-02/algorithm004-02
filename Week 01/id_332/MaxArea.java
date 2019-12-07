package com.hao.leetcode;

public class MaxArea {

    public static int maxAreaF(int[] height) {

        int result = 0;
        for (int width = 1; width <= height.length - 1; width++) {
            int j = 0;
            for (; (j + width) < height.length; j++) {
                result = Math.max(width * Math.min(height[j], height[j + width]), result);
            }
        }
        return result;
    }


    public static int maxAreaS(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            result = Math.max((j - i) * Math.min(height[j], height[i]), result);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

}
