package com.arithmetic.arithmetic.week02;

public class LeetCode_242_657 {



    public static boolean isAnagram(String s, String t) {
        int[] b = new int[26];
        for(int i = 0; i < s.length(); i++) {
            b[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            if(--b[t.charAt(i) - 'a'] < 0) return false;
        }
        return s.length() == t.length();
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s,t));
    }
}
