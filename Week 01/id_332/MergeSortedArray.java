package com.hao.leetcode;


//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针


public class MergeSortedArray {

    //双指针 / 从前往后
    public static void mergeF(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int point1_copy = 0;
        int point2 = 0;

        int point1 = 0;

        while (point1_copy < m && point2 < n) {
            nums1[point1++] = (nums1_copy[point1_copy] < nums2[point2]) ? nums1_copy[point1_copy++] : nums2[point2++];
        }
        if (point1_copy < m) {
            System.arraycopy(nums1_copy, point1_copy, nums1, point1_copy + point2, m + n - point1_copy - point2);
        }
        if (point2 < n) {
            System.arraycopy(nums2, point2, nums1, point1_copy + point2, m + n - point1_copy - point2);
        }
    }

    //双指针 / 从后往前
    public static void mergeS(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m;
        int p2 = n;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        if (p1 >= 0) {
            return;
        }
        if (p2 >= 0) {
            for (; p2 >= 0; p2--) {
                nums1[p2] = nums2[p2];
            }
        }
    }

}
