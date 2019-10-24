/**
 * @(#)RotateArray.java, Oct 16, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * 题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 *
 * 题解：
 * 1.开辟辅助空间：开辟一个和原数组一样的空间，在完成交换后元素所在的新位置满足：
 * 1.暴力求解：逐一交换数组的元素，交换k%nums.length次，时间复杂度O(k * n)
 * 2.旋转数组：这个方法太巧妙了，压根儿没想过，先将整个数组旋转，在旋转前K个元素，在旋转后n-k个元素
 */

/**
 * @author helloliu
 */
public class RotateArray {


    //solution1:
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        int pre = nums[nums.length - 1];
        for (int i = 0; i < k; i++) {

            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }


    //solution2:
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}