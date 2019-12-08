package com.arithmetic.arithmetic.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_46_657 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] flag = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            flag[i] = true;
        }

        allPermute(nums, flag, result, new ArrayList());
        return result;

    }

    public void allPermute(int[] nums, boolean[] flag, List<List<Integer>> result, List<Integer> nowList) {
        if (nowList.size() == nums.length) {
            result.add(new ArrayList(nowList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                nowList.add(nums[i]);
                flag[i] = false;

                allPermute(nums, flag, result, nowList);

                flag[i] = true;
                nowList.remove(nowList.size() - 1);
            }
        }
    }

}
