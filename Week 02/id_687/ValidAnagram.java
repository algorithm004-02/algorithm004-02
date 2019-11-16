package com.itliusir.hash;

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
 * @since 2019/10/23
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean isAnagram = new ValidAnagram().isAnagramTwo(s, t);
        System.out.println(isAnagram);
    }

    /**
     * method 1 -> time O(n * log n) space O(1)
     * <p>
     * 排序，然后对比
     *
     * @author liugang 2019/10/23 18:26
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

    /**
     * method 2 -> time O(n) space O(1)
     * <p>
     * 使用数组构造hash表，hash值使用字母的顺序来记录，
     * 一个往里面填充 一个取，hash表为空则说明是字母异位词
     *
     * @author liugang 2019/10/23 18:27
     */
    public boolean isAnagramTwo(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] words = new int[26];
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
            words[t.charAt(i) - 'a']--;
        }
        for (int word : words) {
            if (word != 0) {
                return false;
            }
        }
        return true;
    }
}
