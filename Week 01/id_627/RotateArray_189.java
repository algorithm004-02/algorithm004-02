package com.example.leetcode;

public class RotateArray_189 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int j = 0;
        for (int i = 0; j < nums.length; i++) {
            int m = i;
            int prev = nums[i];
            do {
                int n = (m + k) % nums.length;
                int temp = nums[n];
                nums[n] = prev;
                prev = temp;
                m = n;
                j++;
            } while (i != m);
        }
    }


}
