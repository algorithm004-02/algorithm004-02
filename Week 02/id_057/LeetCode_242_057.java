package app.homeworkWeekTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.84%)
 * Likes:    899
 * Dislikes: 119
 * Total Accepted:    414.1K
 * Total Submissions: 767.8K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */

// @lc code=start
class Solution {

    /**
     * 另一种思考方式
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphaNums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphaNums[s.charAt(i) - 'a']++;
        }
        for (char tchar : t.toCharArray()) {
            if (alphaNums[tchar - 'a'] == 0) {
                return false;
            }
            alphaNums[tchar - 'a']--;
        }

        return true;
    }

    /**
     * 主要是知道常识，a至z，进行加减法时会首先转成Int，对应的是97至122
     * 例如 'z' - 'a' = 25
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_fast(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphaNums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphaNums[s.charAt(i) - 'a']++;
            alphaNums[t.charAt(i) - 'a']--;
        }
        for (int i : alphaNums) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram_hashMap(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfPresent(s.charAt(i), (key,oldValue) -> oldValue + 1);
            map.putIfAbsent(s.charAt(i), 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            map.computeIfPresent(t.charAt(i), (key,oldValue) -> oldValue - 1);
        }

        return map.values().stream().collect(Collectors.summingInt(n -> Math.abs(n))) > 0 ? false : true;
    }
}
// @lc code=end

