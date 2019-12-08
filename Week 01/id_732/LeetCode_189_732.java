package com.daoye;

public class LeetCode_189_732 {

    public void rotate(int[] nums, int k) {

        int res[]=new int[nums.length];
        int m=k%nums.length;

        for(int i=0;i<nums.length;i++){
            res[i]=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[(i+m)%nums.length]=res[i];
        }

    }

}
