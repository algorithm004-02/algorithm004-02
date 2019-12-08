package com.isshelter.study.week01.a.homework03;

import java.util.Arrays;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @link
 */
public class LeetCode_88_482 {
    /**
     * 解法一 利用java封装好的工具
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 解法2分析：
     * 数组只能指定位置加数，所以不知道长数组元素个数只能倒着加
     * 先把短的数组挨个取出来，倒着加到长数组里，把长数组指针倒着移，因为长数组够大能放进去
     * 组合成一个数组后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int k = 0;
        k = nums1.length;

        for(int i = 0; i < nums2.length; i++){
            j = nums2[i];
            nums1[k-1] = j;
            k--;
        }
        Arrays.sort(nums1);
    }

}
