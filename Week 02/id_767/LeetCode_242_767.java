package algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *  给出两个字符串，判断是否元素内容一样，但位置可能不同。
 * @author lixilong
 * @date 2019/10/24
 */
public class _242_IsAnagram {


  public static void main(String[] args) {
    String s ="a", t = "a";
    _242_IsAnagram isAnagram = new _242_IsAnagram();
    System.out.println(isAnagram.isAnagram(s,t));
  }


//方法1；先排序 Arrays 的排序功能，再比对 n * log n
public boolean isAnagram(String s, String t) {
  if (s.length() != t.length()) return false;
  char[] as = s.toCharArray();
  char[] ts = t.toCharArray();
  Arrays.sort(as);
  Arrays.sort(ts);
  return Arrays.equals(as, ts);
}


//方法2： (Hash Table)  O(n)  O(1)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++; // ++ 和 ——操作后，相同元素只要出现次数相同，会对应到相同索引位置。
        counter[t.charAt(i) - 'a']--; // 所以如次数相同，对应值会变为0
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}

//方法2的改进版本
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
        table[s.charAt(i) - 'a']++; //一轮循环结束，每个计数器都应该为非负值
    }
    for (int i = 0; i < t.length(); i++) {
        table[t.charAt(i) - 'a']--;
        if (table[t.charAt(i) - 'a'] < 0) {
            return false;   //如果在任何时候计数器低于零，我们知道 tt 包含一个不在 ss 中的额外字母，并立即返回 FALSE。
        }
    }
    return true;
}

//方法3；分别对对应的元素计数，最后比较两个map是否相同 O（n）+ O (1)
Map<Character,Integer> sMap = new HashMap();
Map<Character,Integer> tMap = new HashMap();

  public boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    boolean isAnagram = false;
    if (sChars.length < 1 || tChars.length < 1 || sChars.length != tChars.length) {
      return isAnagram;
    }
    for (int i = 0; i < sChars.length; i++) { //因为 sChars.length == tChars.length，所以此时用一个即可
      if (sMap.containsKey(sChars[i])) {
        sMap.put(sChars[i], sMap.get(sChars[i]) + 1);
      } else {
        sMap.put(sChars[i], 1);
      }
      if (tMap.containsKey(tChars[i])) {
        tMap.put(tChars[i], tMap.get(tChars[i]) + 1);
      } else {
        tMap.put(tChars[i], 1);
      }
    }
    return sMap.equals(tMap);
  }

//方法4: 对以一个字符串的的元素存储，最后拿第二个map判断是否相同 O（n）+ O (n)
// 算法有问题，具体再参详
  Map<Integer,Character> charMap = new HashMap();
  public boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    boolean isAnagram = false;
    if ((sChars.length == 0) && ( tChars.length == 0)) return true;
    if (sChars.length < 1 || tChars.length < 1 || sChars.length != tChars.length) {
      return isAnagram;
    }
    for (int i = 0; i < sChars.length; i++) {
      charMap.put(i, sChars[i]);
    }
    for (int j = 0; j < tChars.length; j++) {
      if (charMap.containsValue(tChars[j])){
        if (!charMap.get(j).equals(tChars[j])){
          isAnagram = true;
        }
      }else {
        return false;
      }
    }
    return isAnagram;
  }

}
