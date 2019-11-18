package src.main.java.com.fans.algorithm00402.week2.homework;


/* 【有效的字母异位词】
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_242_232 {

    /* 1. 暴力法  O(N * logN) O(n)
     *  - 直接sort一遍
     *  - 比较是否相等
     *  */
//    public boolean isAnagram(String s, String t) {
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//
//        return Arrays.equals(str1 , str2);
//    }

    /* 2. 使用hash记录字母出现的次数  O(n), O(n)  但是实际执行了30ms， 效率低。
     * - 遍历s， 记录每一个字符出现的次数
     * - 遍历t， 相应的在遍历s的基础上做减法
     * - 最后的结果， 如果Hash中的所有字符出现的次数不为0， 则为false
     * */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i ++) {
            char ch = s.charAt(i);
            if (hashMap.get(ch) != null) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        for (int i = 0 ; i < t.length() ; i ++) {
            char ch = t.charAt(i);
            if (hashMap.get(ch) != null) {
                Integer count = hashMap.get(ch) - 1;
                if (count == 0) {
                    hashMap.remove(ch);
                } else {
                    hashMap.put(ch, count);
                }
            }
        }

        return hashMap.isEmpty();
    }
}
