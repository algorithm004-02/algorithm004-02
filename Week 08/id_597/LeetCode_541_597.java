/**
 * 541. 反转字符串 II
 * Created by yangwenwei on 2019/12/8.
 */
public class LeetCode_541_597 {
    class Solution {
        public String reverseStr(String s, int k) {
            char[] sc = s.toCharArray();
            for (int start = 0; start < sc.length - 1; start += 2 * k) {
                int i = start, j = Math.min(start + k - 1, sc.length - 1);
                while (i < j) {
                    char temp = sc[i];
                    sc[i++] = sc[j];
                    sc[j--] = temp;
                }
            }
            return new String(sc);
        }
    }
}
