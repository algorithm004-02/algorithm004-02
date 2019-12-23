package src.main.java.com.fans.algorithm00402.week8.practice;

/**
 * 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class LeetCode_344_232 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left]; s[left ++] = s[right]; s[right --] = tmp;
        }
    }
}
