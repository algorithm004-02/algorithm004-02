package week2.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/21 20:49
 *
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class L49 {
  /**
   * 核心思想是让异位词的字符串通过一种计算方式映射成相同的key，放在map中.
   * 下面的解决方式采用了排序字符串.
   * NK(logK)，K是最长的字符串的长度
   * */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String str = String.valueOf(chars);
      if (!map.containsKey(str)) {
        map.put(str, new ArrayList<>());
      }
      map.get(str).add(strs[i]);
    }
    return new ArrayList<>(map.values());
  }

  /**
   * 使用另一种方式映射key. #1#2#0#0.... 数字是a,b,c .. 出现的次数
   * NK
   * */
  public List<List<String>> groupAnagrams1(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      int[] countNums = new int[26];
      char[] chars = strs[i].toCharArray();
      for (int j = 0; j < chars.length; j++) {
        countNums[chars[j] - 'a']++;
      }
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = 0; j < countNums.length; j++) {
        stringBuilder.append("#");
        stringBuilder.append(countNums[j]);
      }
      String str = stringBuilder.toString();
      if (!map.containsKey(str)) {
        map.put(str, new ArrayList<>());
      }
      map.get(str).add(strs[i]);
    }
    return new ArrayList<>(map.values());
  }

}
