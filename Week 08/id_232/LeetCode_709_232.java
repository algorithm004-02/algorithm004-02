package src.main.java.com.fans.algorithm00402.week8.practice;

/**
 * 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class LeetCode_709_232 {
    public String toLowerCase(String str) {
        String ans = "";
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            ans += ch;
        }
        return ans;
    }
}
