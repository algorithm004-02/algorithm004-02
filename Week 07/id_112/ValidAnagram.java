package datastruct.sort;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:
 输入: s = "anagram", t = "nagaram"
 输出: true

 示例 2:
 输入: s = "rat", t = "car"
 输出: false

 */
public class ValidAnagram {

    public boolean isAnagram(String s,String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }

}
