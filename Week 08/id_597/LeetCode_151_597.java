/**
 * 151. 翻转字符串里的单词
 * Created by yangwenwei on 2019/12/8.
 */
public class LeetCode_151_597 {
    class Solution {
        public String reverseWords(String s) {
            char[] sc = s.toCharArray();
            reverse(sc);
            String[] a = new String(sc).trim().split(" +");
            for (int i = 0; i < a.length; i++) {
                String str = a[i];
                char[] arr = str.toCharArray();
                reverse(arr);
                a[i] = new String(arr);
            }
            return String.join(" ", a);
        }

        public void reverse(char[] sc) {
            if (sc == null) return;
            for (int i = 0, j = sc.length - 1; i < j; i++, j--) {
                char tmp = sc[i];
                sc[i] = sc[j];
                sc[j] = tmp;
            }
        }
    }
}
