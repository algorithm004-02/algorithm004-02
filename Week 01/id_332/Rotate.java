package com.hao.leetcode;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组

public class Rotate {
    /**
     * 暴力
     *
     * @param nums
     * @param k
     */
    public static void rotateF(int[] nums, int k) {

        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 使用额外的数组
     *
     * @param nums
     * @param k
     */
    public static void rotateS(int[] nums, int k) {

        int[] a = new int[nums.length];
        for (int i = 0; i < a.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < a.length; i++) {
            nums[i] = a[i];
        }

    }

    /**
     * 使用反转
     *
     * @param nums
     * @param k
     */
    public static void rotateT(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k+1,nums.length);
    }

    /**
     * 使用环状替换
     *
     * @param nums
     * @param k
     */
    public static void rotateFourth(int[] nums, int k) {
        k = k % nums.length;

        int count = 0 ;

        for (int start = 0 ; count < nums.length ; start ++){

            int current = start ;

            int prev = nums[start];

            do{

                int  next = (current+k)%nums.length;

                int temp = nums[next];

                nums[next] = prev;

                prev = temp;

                current = next;

                count ++;
            }while (start != current);

        }


    }


    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
