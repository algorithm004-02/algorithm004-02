/*
    49. 字母异位词分组
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */

public class Solution
{
    // 解法 1: 排序数组分类
    // 先排序, 然后将异位词放入相同的组, 存入哈希表
    // public IList<IList<string>> GroupAnagrams(string[] strs)
    // {
    //     // 定义一个哈希表
    //     Dictionary<string, IList<string>> mapping = new Dictionary<string, IList<string>>();

    //     // 将排序后相同的单词作为一组存入哈希表
    //     foreach (string str in strs)
    //     {
    //         char[] words = str.ToCharArray();
    //         Array.Sort<char>(words);

    //         string key = new string(words);
    //         if (mapping.ContainsKey(key))
    //         {
    //             mapping[key].Add(str);
    //         }
    //         else
    //         {
    //             mapping.Add(key, new List<string>() { str });
    //         }
    //     }

    //     // 将分组后的异位词返回
    //     return new List<IList<string>>(mapping.Values);
    // }



    // 解法 2:哈希表
    // 核心思路: 计算每个单词里的每个字母出现的次数, 并将该字母出现的次数映射到哈希表里.
    // 然后遍历哈希表后得到一个特殊字符串, 如果两个单词是异位词, 则对应的字符串相同.
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        if (strs == null || strs.Length == 0) return new List<IList<string>>();

        int[] counter = new int[26];
        Dictionary<string, IList<string>> ans = new Dictionary<string, IList<string>>();
        foreach (string s in strs)
        {
            Array.Fill<int>(counter, 0);

            foreach (char c in s) counter[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
            {
                sb.Append("#");
                sb.Append(counter[i]);
            }

            string key = sb.ToString();
            if (!ans.ContainsKey(key))
            {
                ans.Add(key, new List<string>());
            }
            ans[key].Add(s);
        }

        return new List<IList<string>>(ans.Values);
    }
}