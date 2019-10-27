package main.java.com.fans.algorithm00402.week1.homework;

import java.util.Arrays;

/**
 * 【合并两个有序数组】
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class LeetCode_88_232 {

    public static void main(String[] args) {
        LeetCode_88_232 code = new LeetCode_88_232();
        int[] numn1 = new int[]{0};
        int[] numn2 = new int[]{1};
        code.merge(numn1, 0, numn2, 1);
        System.out.println(Arrays.toString(numn1));
    }

    // 1. 使用额外的数组，排序好，再赋值回来 时：O(n + m)  空：O(n + m)
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (nums2.length == 0) return;
//        if (nums1.length == 0) {
//            for (int i = 0 ; i < n ; i ++) {
//                nums1[i] = nums2[2];
//            }
//            return;
//        }
//        int[] a = new int[m + n];
//
//        int k = 0, j = 0, i = 0;
//        while (k < m && j < n) {
//            if (nums1[k] < nums2[j]) {
//                a[i ++] = nums1[k];
//                k ++;
//            } else {
//                a[i ++] = nums2[j];
//                j ++;
//            }
//        }
//        while (k < m) a[i ++] = nums1[k ++];
//        while (j < n) a[i ++] = nums2[j ++];
//
//        for (i = 0 ; i < a.length ; i ++) {
//            nums1[i] = a[i];
//        }
//    }

    // 2. 学习leetCode官方 双指针，从后往前  时：O(n + m)  空：O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0)
            nums1[p --] = (nums1[p1] < nums2[p2]) ? nums2[p2 --] : nums1[p1 --];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
