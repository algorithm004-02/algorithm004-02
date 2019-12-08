/*
    242. 有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Solution
{
    // 暴力解法
    // 排序后比较两个数组相同索引位置的元素是否相同, 如果任意一组不相同, 则返回 false.
    // public bool IsAnagram(string s, string t)
    // {
    //     if (s.Length != t.Length) return false;

    //     char[] sourceArray = s.ToCharArray();
    //     char[] targetArray = t.ToCharArray();

    //     Array.Sort(sourceArray);
    //     Array.Sort(targetArray);

    //     for (int i = 0; i < sourceArray.Length; i++)
    //     {
    //         if (sourceArray[i] != targetArray[i]) return false;
    //     }
    //     return true;
    // }


    // 
    // a-z 的字母减去 a 的差值必定在 0-26 之间
    // 因此将该差值作为索引, 不断更新该索引位置的数值, 相同的字母将会更新同一个位置的值
    // 遍历一遍后, 若 s 和 t 是易位词, 则每个索引位置的值应该为 0
    public bool IsAnagram(string s, string t)
    {
        if (s.Length != t.Length) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.Length; i++)
        {
            counter[s[i] - 'a']++;
            counter[t[i] - 'a']--;
        }

        foreach (int n in counter)
        {
            if (n != 0) return false;
        }

        return true;
    }
}