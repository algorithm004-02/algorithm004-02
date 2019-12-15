package app.homeworkWeekEighth;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.79%)
 * Likes:    1312
 * Dislikes: 92
 * Total Accepted:    354.5K
 * Total Submissions: 694.1K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 使用LinkedHashMap
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) 
            if (map.get(s.charAt(i)) == 1) 
                return i;
            
        return -1;
        
    }
}
// @lc code=end

