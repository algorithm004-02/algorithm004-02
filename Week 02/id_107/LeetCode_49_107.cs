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
}