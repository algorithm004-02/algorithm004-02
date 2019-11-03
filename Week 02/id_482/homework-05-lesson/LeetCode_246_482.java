package com.study.homework.week02_5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/22
 * @link https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_246_482 {

    /**
     * 解法一： 暴力法
     * 排序 然后比较
     * 时间复杂度： O（nlogn）
     * 空间复杂度 O（1）
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char [] arrS= s.toCharArray();
        char [] arrT= t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);

        return Arrays.equals(arrS,arrT);
    }

    /**
     * 使用一个额外数组来计数
     * 时间复杂度： O（n）
     * 空间复杂度 O（1）
     */
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int [] count=new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0 )
                return false;
        }
        return true;
    }


}
