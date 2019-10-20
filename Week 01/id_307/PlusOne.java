// https://leetcode-cn.com/problems/plus-one/
class Solution {
    public int[] plusOne(int[] digits) {
        int pos = digits.length - 1;
        while (pos > -1 && (digits[pos] = (digits[pos] + 1) % 10) == 0) {
            pos--;
        }
        if (pos < 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}