/*
    387. 字符串中的第一个唯一字符
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
*/

// 解法1: 第一次遍历, 使用哈希表记录每个字符出现的次数; 第二次遍历, 返回字数数量等于1的字符的索引
public class Solution {
    public int FirstUniqChar(string s) {
        Dictionary<char,int> map = new Dictionary<char,int>();
        foreach(char c in s.ToCharArray())
        {
            map[c]  = map.TryGetValue(c, out int val) ? ++val : 1;
        }
        
        for(int i = 0; i < s.Length; i++)
        {
            if(map.TryGetValue(s[i] , out int val) && val == 1) return i;
        }
        
        return -1;
    }
}