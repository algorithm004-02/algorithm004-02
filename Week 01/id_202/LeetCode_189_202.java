package com.algorithm.qinchao.homework.week01;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/17 09:54
 * @description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_189_202 {

    /**
     * 暴力解法
     * @param nums
     * @param
     * @description 时间复杂度 = O(k*n)
     */
    public void rotateByViolence(int[] nums, int k) {
        //保留更换过的值
        int change;
        //用于交换的值
        int temp;
        //需要更换k个数
        for (int i = 0; i < k; i++) {
            //尾部开始更换
            change = nums[nums.length - 1];
            //更换后依次迭代
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = change;
                change = temp;
            }
        }
    }


    /**
     *
     * @param nums
     * @param k
     * @description 时间复杂度 = O(n)+O(n)+O(n)=O(3n)=O(n)
     */
    public void rotateBySwap(int[] nums, int k) {
        //防止指针越界，k比nums的大小大时
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int begin, int end) {
        int temp;
        while (begin < end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }


    public static void main(String[] args) {
        LeetCode_189_202 leetCode_189_202 = new LeetCode_189_202();
        int[] nums = {1,2};
        leetCode_189_202.rotateByViolence(nums, 3);
        printArray(nums);
        nums = new int[]{1,2,3,4,5,6};
        leetCode_189_202.rotateBySwap(nums, 6);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
