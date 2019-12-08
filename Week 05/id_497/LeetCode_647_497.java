class Solution {
    int total = 0;
    int length;

    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        length = s.length();
        if (length == 1) {
            return 1;
        }
        //考虑aba , ccaacc 2种回文情况
        for (int i = 0; i < length; i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return total;
    }

    private void findPalindrome(String s, int leftStart, int rightStart) {
        while (leftStart >= 0 && rightStart < length && s.charAt(leftStart) == s.charAt(rightStart)) {
            total++;
            leftStart--;
            rightStart++;
        }
    }
}