/*
 * @lc app=leetcode.cn id=387 lang=csharp
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (41.02%)
 * Likes:    161
 * Dislikes: 0
 * Total Accepted:    50.8K
 * Total Submissions: 121.9K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
public class Solution
{
    public int FirstUniqChar(string s)
    {
        int[] alphabet = new int[26];

        // 总共就26个字母，用数组统计每个字母出现的次数
        for (int i = 0; i < s.Length; i++)
        {
            alphabet[s[i] - 'a']++;
        }

        // 循环字符串，找到第一个出现次数为1的字母
        for (int i = 0; i < s.Length; i++)
        {
            if (alphabet[s[i] - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
// @lc code=end

// public class Solution
// {
//     public int FirstUniqChar(string s)
//     {
//         Dictionary<char, int> dic = new Dictionary<char, int>();
//         for (int i = 0; i < s.Length; i++)
//         {
//             if (dic.ContainsKey(s[i]))
//             {
//                 dic[s[i]]++;
//             }
//             else
//             {
//                 dic.Add(s[i], 1);
//             }
//         }

//         for (int i = 0; i < s.Length; i++)
//         {
//             if (dic[s[i]] == 1)
//                 return i;
//         }

//         return -1;
//     }
// }