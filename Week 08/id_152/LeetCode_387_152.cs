public class Solution {
    public int FirstUniqChar(string s) {
        Dictionary<char, int> counters = new Dictionary<char, int>(26);
        for (char i = 'a'; i <= 'z'; i++)
        {
            counters[i] = 0;
        }
        foreach(var letter in s)
        {
            counters[letter]++;
        }
        
        for (int i = 0; i < s.Length; i++)
        {
            if (counters[s[i]] == 1)
            {
                return i;
            }
        }
              
        return -1;
    }
}