package com.study.week3.lesson10;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/30
 * @link https://leetcode-cn.com/problems/assign-cookies/
 */
public class LeetCode_455_482 {

    public int findContentChildren(int[] g, int[] s) {
        if (null == g || s == null || g.length==0 || s.length ==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int gIndex=0,sIndex=0;
        while (gIndex <g.length && sIndex<s.length) {
            if (g[gIndex] <= s[sIndex++]) {
                count++;gIndex++;
            }
        }
        return count;
    }
}
