/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (55.97%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    54.8K
 * Total Submissions: 96.6K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;

        int map[26] = {0};

        for (int i = 0; i < s.length(); ++i) {
            map[s[i] - 'a']++;
        } 

        for (int i = 0; i < t.length(); ++i) {
            map[t[i] - 'a']--;
            if (map[t[i] - 'a'] < 0) return false;
        }

        return true;
    }
};
// @lc code=end

