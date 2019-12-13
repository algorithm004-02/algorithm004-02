package com.itliusir.array;

import com.itliusir.util.PrintArrayUtil;

/**
 * problem.88
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author liugang
 * @date 2019-10-20
 */
public class SortArrayMerge {

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 5, 6};
        new SortArrayMerge().mergeTwo(nums1, 3, nums2, 3);
        PrintArrayUtil.printArray(nums1);
    }

    /**
     * method 1 -> time O(m + n) space(copy space) O(m)
     * <p>
     * 双指针 从前往后
     *
     * @author liugang
     * @date 2019-10-20 17:16:59
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }
        // nums1 is still elm to add
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - (p1 + p2));
        }
        // nums2 is still elm to add
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - (p1 + p2));
        }
    }

    /**
     * method 2 -> time O(m + n) space(no-copy space) O(1)
     *
     * 经分析可以发现在方法1中nums1的后面空间在最初是浪费的，所以需要开辟新的空间暂存之前数据，这里使用从后向前指针，利用此处空间。
     * @author liugang
     * @date 2019-10-20 17:28:02
     */
    public void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p1 >=0 && p2 >=0) {
            nums1[p--] = nums2[p2] > nums1[p1] ? nums2[p2--] : nums1[p1--];
        }
        // cover nums1 head elem
        System.arraycopy(nums2 , 0 , nums1 , 0 , p2 + 1);
    }

}
