package src.main.java.com.fans.algorithm00402.week8.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 */
public class LeetCode_14_232 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i ++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
