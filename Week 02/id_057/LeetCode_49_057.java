package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (49.98%)
 * Likes:    2149
 * Dislikes: 134
 * Total Accepted:    420.2K
 * Total Submissions: 837.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * 采用判断Anagrams最快的算法
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tChars = strs[i].toCharArray();
            Arrays.sort(tChars);
            String s = new String(tChars);

            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                result.add(list);
                map.put(s, list);
            }

            map.get(s).add(strs[i]);
        }
        return result;
    }
}
// @lc code=end

