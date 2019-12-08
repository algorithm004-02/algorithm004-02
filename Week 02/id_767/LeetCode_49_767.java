package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * describe:
 *
 *
 * 方法一，都用26个质数构造哈希值，体现为
 * int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
 *              59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z\
 * 方法二，自己定义key的规则。
 *
 * @author lixilong
 * @date 2019/10/25
 */
public class _49_GroupAnagrams {

  Map<String,int[]> hashMap = new HashMap();
  ArrayList arrayList = new ArrayList();
  Set<Integer> hashSet = new HashSet();

  //方法一： 29 ms 后续再观察
  public  List<List<String>> groupAnagrams(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97, 101, 103};//最多10609个z

    List<List<String>> res = new ArrayList();
    HashMap<Integer, Integer> map = new HashMap();
    for (String s : strs) {
      int key = 1;
      for (char c : s.toCharArray()) { //对每个单词的字母分割
        key *= prime[c - 'a'];
      }

      List<String> t;
      if (map.containsKey(key)) { //已出现的字母异位组
        t = res.get(map.get(key));
      } else {
        t = new ArrayList(); //首次出现的字母异位组
        res.add(t);
        map.put(key, res.size() - 1);
      }
      t.add(s);
    }
    return res;
  }

    ///方法二： 28 ms
    public List<List<String>> groupAnagrams(String[] strs) {
      if (strs.length == 0) return new ArrayList();
      Map<String, List> ans = new HashMap<String, List>();
      int[] count = new int[26];
      for (String s : strs) {
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) count[c - 'a']++;

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
          sb.append('#');
          sb.append(count[i]);  //对每个单词的字母切分并得到，和顺序无关的key
        }
        String key = sb.toString();
        if (!ans.containsKey(key)) ans.put(key, new ArrayList());
        ans.get(key).add(s);
      }
      return new ArrayList(ans.values());
    }


    // 方法三，单词内字母排序，本质也是构造key.
    public List<List<String>> groupAnagrams(String[] strs) {
      if (strs.length == 0) {
        return new ArrayList();
      }
      Map<String, List> ans = new HashMap<String, List>();
      for (String s : strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = String.valueOf(ca);
        if (!ans.containsKey(key)) {
          ans.put(key, new ArrayList());
        }
        ans.get(key).add(s);
      }
      return new ArrayList(ans.values());
    }

}
