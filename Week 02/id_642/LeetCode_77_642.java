package week2.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/26 17:45
 * https://leetcode-cn.com/problems/combinations/submissions/
 */
public class L77 {
  /**
   * C(n, k) = C(n - 1, k - 1) + C(n - 1 ,k)
   * */
  public List<List<Integer>> combine(int n, int k) {
    if (k == n || k == 0) {
      List<Integer> list = new ArrayList<>();
      for (int i = 1; i <= k; i++) {
        list.add(i);
      }
      return new ArrayList<>(Arrays.asList(list));
    }
    List<List<Integer>> result = combine(n - 1 ,k - 1);
    result.forEach(r -> r.add(n));
    result.addAll(combine(n - 1, k));
    return result;
  }
}
