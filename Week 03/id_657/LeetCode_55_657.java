package com.arithmetic.arithmetic.week03;

public class LeetCode_55_657 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i <= max; i++){
            max = Math.max(nums[i] + i,max);
            if(max >= nums.length - 1)
                return true;
        }
        return false;
    }
}
