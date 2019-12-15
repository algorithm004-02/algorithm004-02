package Week7;

import java.util.Arrays;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/3 23:36
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class L242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Arrays.sort(sChars);
    Arrays.sort(tChars);
    return String.valueOf(sChars).equals(String.valueOf(tChars));
  }


  public boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] arr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a'] += 1;
      arr[t.charAt(i) - 'a'] -= 1;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
