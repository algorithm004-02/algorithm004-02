package week2.work;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/21 16:52
 *
 * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
 */
public class L242 {
  /**
   * 第一次提交代码.
   * 使用HashMap实现.
   * */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    /** 先使用map记录s中所有字符出现的次数 */
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    /** 遍历t，依次从map中移除这个字符，如果是异位词，map最后是空的 */
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c);
        if (count == 1) {
          map.remove(c);
        } else {
          map.put(c, count - 1);
        }
      } else {
        return false;
      }
    }
    return map.isEmpty();
  }

  /**
   * 参考题解实现。
   * 都是小写字母，那么一共最多26个，定一个大小为26的数组，计数比较.
   * */
  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] array = new int[26];
    for (int i = 0; i < s.length(); i++) {
      array[s.charAt(i) - 'a']++;
      array[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
