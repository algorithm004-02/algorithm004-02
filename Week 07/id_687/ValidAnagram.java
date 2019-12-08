package com.itliusir.sort;

import java.util.Arrays;

/**
 * problem.20
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * @author liugang
 * @since 2019-12-01
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean isAnagram = new ValidAnagram().isAnagram(s, t);
        System.out.println(isAnagram);
    }

    /**
     * method 1 -> time O(n * log n) space O(1)
     * <p>
     * 排序，然后对比
     *
     * @author liugang 2019-12-01 22:47:33
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
