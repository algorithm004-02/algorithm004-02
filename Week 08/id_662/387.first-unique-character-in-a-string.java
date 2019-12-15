/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

class Solution {
    public int firstUniqChar(String s) {
        char[] arr = new char[58];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }
}