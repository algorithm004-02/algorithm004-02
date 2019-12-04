package com.study.week3.lesson11;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/11/1
 * @link
 */
public class LeetCode_153_482 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int le=0;
        int r=nums.length-1;

        while (le < r) {
            int mid=le + (r - le)/2;
            if (nums[mid] > nums[r]) {
                le=mid+1;
            }else {
                r=mid;
            }
        }
        return nums[r];
    }
}
