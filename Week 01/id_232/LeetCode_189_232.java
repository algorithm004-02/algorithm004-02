package main.java.com.fans.algorithm00402.week1.homework;

/* 【旋转数组】
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
* */

import java.lang.reflect.Array;
import java.security.Key;
import java.util.Arrays;

public class LeetCode_189_232 {

    public static void main(String[] args) {
        LeetCode_189_232 code = new LeetCode_189_232();
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        code.rotate(nums, 10);
        System.out.println(Arrays.toString(nums));
    }

    // 1. 暴力法 ： 一次右移一个位置， 循环k次 (超时了。。。。。)  时：O(k * n)  空：O(1)
//    public void rotate(int[] nums, int k) {
//        if (nums.length == 0) return;
//        k = k % nums.length;
//        for (int i = 0 ; i < k ; i ++) {
//            int pastVal = nums[0];
//            for (int j = 0 ; j < nums.length ; j ++) {
//                int index = (j + 1) % nums.length;
//                int temp = nums[index];
//                nums[index] = pastVal;
//                pastVal = temp;
//            }
//        }
//    }

    // 2. 一次向右边移动 k 位 (建立一个缓存， 存下中间会被覆盖掉的元素) 时：O(n) 空：O(k)
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        if (nums.length < 2 || k == 0) return;
//        int[] cache = new int[k];
//        for (int j = 0 ; j < nums.length ; j ++) {
//            int index = (j + k) % nums.length;
//            int cacheIndex = j % k;
//            int temp = nums[index];
//            if (j >= k) {
//                nums[index] = cache[cacheIndex];
//            } else {
//                nums[index] = nums[j];
//            }
//            cache[cacheIndex] = temp;
//        }
//    }

    // 3. 使用新数组保存结果， 最后再复制回去   时：O(n)  空：(n)
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        if (nums.length < 2 || k == 0) return;
//
//        int[] a = new int[nums.length];
//        for (int i = 0 ; i < nums.length ; i ++) {
//            a[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0 ; i < nums.length ; i ++) {
//            nums[i] = a[i];
//        }
//    }

    // 4. 按照裁剪位置反置数组  时：O(n + k) 空：O(k)
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        if (nums.length < 2 || k == 0) return;
//
//        int index = nums.length - k; // 裁剪位置
//        int[] a = new int[k];
//        for (int i = 0; i < k; i ++) {
//            a[i] = nums[index + i];
//        }
//
//        for (int i = nums.length - k - 1 ; i >= 0 ; i --) {
//            nums[i + k] = nums[i];
//        }
//
//        for (int i = 0 ; i < k ; i ++) {
//            nums[i] = a[i];
//        }
//    }

    // 5. 反转  时：O(n) 空：O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
