package src.main.java.com.fans.algorithm00402.week8.practice;

import java.util.Arrays;

/**
 *  字符串中的第一个唯一字符
 *   https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387_232 {

    /**
     * 暴力法
     */
//    public int firstUniqChar(String s) {
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < chars.length; i ++) {
//            for (int j = 0; j < chars.length; j ++) {
//                if (i != j && chars[i] == chars[j]) break;
//                if (j == chars.length - 1) return i;
//            }
//        }
//
//        return -1;
//    }

    /**
     * 两次遍历
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < chars.length; i ++) hash[chars[i] - 'a'] ++;
        for (int i = 0; i < chars.length; i ++) {
            if (hash[chars[i] - 'a'] == 1) return i;
        }

        return -1;
    }
}
