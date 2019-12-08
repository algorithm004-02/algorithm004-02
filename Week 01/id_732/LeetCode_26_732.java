package com.daoye;

/**
 * @author Asus
 */
public class LeetCode_26_732 {

    public int removeDuplicates(int[] nums) {
        // 非空判断
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
