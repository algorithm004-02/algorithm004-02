package src.main.java.com.fans.algorithm00402.week8.practice;

import java.util.List;

/**
 * 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LeetCode_58_232 {
    /**
     * 直观想法
     */
//    public int lengthOfLastWord(String s) {
//        String[] list = s.split(" ");
//        if (list.length > 0) {
//            return list[list.length - 1].length();
//        }
//        return 0;
//    }

    /**
     * 反向遍历的过程中统计
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index >= 0 && chars[index] == ' ') index --;
        if (index < 0) return 0;
        while (index >= 0 && chars[index] != ' ') {
            index --;
            count ++;
        }
        return count;
    }
}
