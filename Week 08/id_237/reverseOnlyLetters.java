class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && (chars[i] < 'A' || (chars[i] > 'Z' && chars[i] < 'a') || chars[i] > 'z')) i++;
            while (i < j && (chars[j] < 'A' || (chars[j] > 'Z' && chars[j] < 'a') || chars[j] > 'z')) j--;
            if(i < j) {
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i++] ^= chars[j--];
            }
        }
        return String.valueOf(chars);
    }
}