package com.study.homework.week02_5;

import java.util.Arrays;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/27
 * @link https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_242_482 {

    /**
     * 解法一： 排序 然后比较
     * @param s
     * @param t
     * @return
     * 需要想到 可以使用排序 然后进行比较这种解法；
     * 另外，要熟悉代码的书写
     */
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length())
            return false;

        char [] sc=s.toCharArray();
        char [] tc=t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);
    }

    /**
     * 解法2 使用哈希表（k，v）思想
     * 分析：因为只存储字母，所以定义一个 数组，index代表k，索性所在值代表v
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int [] tmp=new int[26];//代表26个字母

        for (int i = 0; i < s.length(); i++) {
            tmp[s.charAt(i) - 'a']++;
            tmp[t.charAt(i) - 'a']--;
        }
        return Arrays.equals(tmp,new int[26]);
    }



}
