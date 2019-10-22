package com.hao.leetcode;

public class MoveZeroes {

    public static void moveZeroesF(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int j = lastNonZeroFoundAt; j < nums.length; j++) {
            nums[j] = 0;
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
    }

    public static void moveZeroesS(int[] nums) {
        int temp = 0;
        for (int j = 0, lastNonZeroFoundAt = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                temp = nums[j];
                nums[j] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
            for (int n : nums) {
                System.out.print(n);
            }
                System.out.println();
        }
    }




}
