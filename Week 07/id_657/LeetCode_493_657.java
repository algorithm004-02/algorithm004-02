package com.arithmetic.arithmetic.week07;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LeetCode_493_657 {
    int[] C;
    int N;

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int x, int v) {
        x++;
        for (int i = x; i <= N; i += lowbit(i)) {
            C[i] += v;
        }
    }

    private int sum(int x) {
        x++;
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += C[i];
        }
        return res;
    }

    public int reversePairs(int[] nums) {
        TreeSet<Long> set = new TreeSet<>();
        for (int num : nums) {
            long ln = Long.valueOf(num);
            set.add(ln);
            set.add(ln * 2);
        }

        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        for (Long num : set) {
            map.put(num, i++);
        }

        N = set.size();
        C = new int[N + 1];

        int ans = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            long ln = Long.valueOf(nums[j]);
            ans += sum(map.get(ln) - 1);
            add(map.get(ln * 2), 1);
        }

        return ans;
    }
}
