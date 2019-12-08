package com.kaiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_157 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return  ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        dfs(ans, nums, list, i + 1);
        list.add(nums[i]);
        dfs(ans, nums, list, i + 1);
        list.remove(list.size() - 1);
    }
}
