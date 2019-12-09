package com.study.week8;

public class LeetCode_541_482 {
}
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (k == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char c;
        int p;
        int q;
        for (int i = 0; i < chars.length; i += 2 * k) {
            q = i;
            p = Math.min(i + k - 1, chars.length - 1);
            while (p > q) {
                c = chars[p];
                chars[p--] = chars[q];
                chars[q++] = c;
            }
        }

        return String.valueOf(chars);
    }
}


