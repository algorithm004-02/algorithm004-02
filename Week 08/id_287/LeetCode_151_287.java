package com.tulane.leetcode.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_151 {

    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String stmp : arr) {
            if (!"".equals(stmp.trim())) list.add(stmp);
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
