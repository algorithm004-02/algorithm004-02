package com.itliusir.array;

import com.itliusir.util.PrintArrayUtil;

/**
 * problem.189
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * @author liugang
 * @date 2019-10-20
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        new RotateArray().rotateThree(nums, k);
        PrintArrayUtil.printArray(nums);
    }

    /**
     * method 1 -> time O(k * n) space O(1)
     * <p>
     * 暴力求解1
     *
     * @author liugang
     * @date 2019-10-20 02:59:53
     */
    public void rotate(int[] nums, int k) {
        int temp = 0, lastItem = 0;
        for (int i = 0; i < k; i++) {
            lastItem = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = lastItem;
                lastItem = temp;
            }
        }
    }

    /**
     * method 2 -> time O(n) space O(n)
     * <p>
     * 暴力求解2
     *
     * @author liugang
     * @date 2019-10-20 03:06:52
     */
    public void rotateTwo(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    /**
     * method 3 -> time O(n) space O(1)
     * <p>
     * 巧妙使用多次翻转来求解
     *
     * @author liugang
     * @date 2019-10-20 03:18:32
     */
    public void rotateThree(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int firstIndex, int lastIndex) {
        while (firstIndex < lastIndex) {
            int temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
    }


}
