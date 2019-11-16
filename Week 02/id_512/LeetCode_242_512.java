package WEEK2.LeetCode.HashTableQuestion;

import java.util.Arrays;
import java.util.HashMap;

/**
 * No.242
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 “你可以假设字符串只包含小写字母。”

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
/*
 * 异位词-字符串中每一个字母出现的次数都一致的所有单词
 */
public class ValidAnagram {
    /* tips: 我的想法是遍历所有字符的出现个数。与第二个匹配。 */

    /**
     方法1：暴力求解
     思路：把两个字符串全部遍历，且排序一遍。生成的字符相等则为Anagram
     */
    //O(n*logN) -> sort
    //排序两个字符串，然后对比。
    //python: sorted(s) == sorted(t)
    public boolean isAnagram_SortedString(String s, String t) {
        if (s.length() != t.length())  //check length
            return false;

        char[] chars = s.toCharArray();   //利用ArraySort
        char[] chart = s.toCharArray();   //利用ArraySort
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);
    }

    /**
     方法2：遍历俩字符串，存在hashMap里，s对应字符数字+1,t对应数字-1.
     思路：当 hash 表中某个字符的个数小于 0 时直接返回 false。
     tips: 我的想法是遍历所有字符的出现个数。与第二个匹配。
    */
    public boolean isAnagram_Map(String s, String t) {
        if (s.length() != t.length())  //check length
            return false;
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     方法3：遍历俩字符串，存在数组里，s对应char+1,t对应char-1.
     思路：所有的26个字符char的数组格子应该都是0
     为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 S 和 T 都只包含 A-Z的字母，所以一个简单的 26 位计数器表就足够了。
     我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。

     */

    public boolean isAnagram_Array(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet)
            if (i != 0) return false;
        return true;
    }
    public boolean isAnagram_FasterArray(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] alpha = new int[26];

        for(int i = 0; i < c1.length; ++i) {
            alpha[c1[i] - 'a']++;
            alpha[c2[i] - 'a']--;
        }

        for(int num: alpha) {
            if(num != 0)
                return false;
        }
        return true;
    }


}
