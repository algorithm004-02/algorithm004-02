/**
 * 680. 验证回文字符串 Ⅱ
 * Created by yangwenwei on 2019/12/8.
 */
public class LeetCode_680_597 {
    class Solution {
        public boolean validPalindrome(String s) {
            char[] arr = s.toCharArray();
            int i = 0, j = arr.length - 1;
            while (i < j) {
                if (arr[i] != arr[j]) {
                    return isPalindrome(arr, i + 1, j) || isPalindrome(arr, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }

        private boolean isPalindrome(char[] arr, int i, int j) {
            while (i < j) if (arr[i++] != arr[j--]) return false;
            return true;
        }
    }
}
