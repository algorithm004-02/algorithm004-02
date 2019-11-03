package com.kaiyun.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kaiyun on 2019/10/22.
 */
public class LeetCode_242_157 {
    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        char [] sc = s.toCharArray();
//        char [] tc = t.toCharArray();
//        Arrays.sort(sc);
//        Arrays.sort(tc);
//        // equals方法，不是使用对象本身的equals方法，而是使用数组提供的方法
//        return Arrays.equals(sc, tc);
// 这种方式引用了外部的hash表，效率很低
//        HashMap<Character,Integer> result = new HashMap<>();
//        for (char a : s.toCharArray()) {
//            int num = result.get(a);
//            num++;
//            result.put(a,num);
//        }
//        for (char b : t.toCharArray()) {
//            int num = result.get(b);
//            num--;
//            result.put(b,num);
//            if (num == 0) {
//                result.remove(b);
//            }
//        }
//        return result.isEmpty();


        // 用字母字符的ASCII 码值作为散列函数，散列表的值存放字符出现的次数，非常巧妙简洁
        if (s.length() != t.length()) return false;
        int[] ab = new int[26];
        for (int i = 0; i < s.length(); i++) ab[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) ab[t.charAt(i) - 'a']--;
        for (int i = 0; i < ab.length; i++) if (ab[i] > 0) return false;
        return true;

    }
}
