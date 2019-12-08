import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    // 暴力法：排序，然后比较是否完全相同
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] strS = s.toCharArray();
        char[] strT = t.toCharArray();
        Arrays.sort(strS);
        Arrays.sort(strT);
        return Arrays.equals(strS, strT);
    }
}
// @lc code=end

class Solution {
    // 写一个哈希表，判断每个字母出现的次数
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}