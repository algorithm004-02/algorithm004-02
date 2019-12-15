package com.kaiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiyun on 2019/10/24.
 */
public class LeetCode_22_157 {
    List<String> strings = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        _generate(n, n, "");
        return strings;
    }
    private void _generate(int left, int right, String s) {
        if (left == 0 && right == 0 ) {
            strings.add(s);
            return;
        }
        if (left > 0) _generate(left - 1, right, s + "(");
        if (right > 0 && right > left) _generate(left, right - 1, s + ")");
    }
}
