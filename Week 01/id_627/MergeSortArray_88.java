package com.example.leetcode;

import java.util.Arrays;

public class MergeSortArray_88 {
    public static void main(String[] args) {


        merge_03(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3);
    }

    public static void merge_01(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]);
        }
    }

    public static void merge_02(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }

        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = arr[p1] < nums2[p2] ? arr[p1++] : nums2[p2++];
        }
        int pp = p1 + p2;
        if (p1 < m) {
            for (int i = p1; i < m; i++) {
                nums1[pp++] = arr[i];
            }
        }
        if (p2 < n) {
            for (int i = p2; i < n; i++) {
                nums1[pp++] = nums2[i];
            }
        }
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]);
        }
    }

    public static void merge_03(int[] nums1, int m, int[] nums2, int n) {
        int p = n+m-1,p1=m-1,p2=n-1;
        while(p1>=0 && p2>=0){
            nums1[p--] = nums1[p1]>nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while(p2>=0){
            nums1[p--] = nums2[p2--];
        }
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]);
        }
    }
}
