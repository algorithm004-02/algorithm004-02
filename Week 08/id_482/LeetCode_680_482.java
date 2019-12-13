package com.study.week8;

public class LeetCode_680_482 {


        public boolean validPalindrome(String s) {
            return isPalindrome(s, 0, s.length() - 1, false);
        }

        private boolean isPalindrome(String s, int i, int j, boolean b) {
            if (i > j)
                return true;
            if (s.charAt(i) == s.charAt(j))
                return isPalindrome(s, i + 1, j - 1, b);
            return !b && (isPalindrome(s, i + 1, j, true) || isPalindrome(s, i, j - 1, true));
        }

}
