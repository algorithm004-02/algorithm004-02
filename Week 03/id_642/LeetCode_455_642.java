package week3.work;

import java.util.Arrays;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/2 09:24
 */
public class L455 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int sum = 0;
    int i = 0;
    int j = 0;
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        sum++;
        i++;
      }
      j++;
    }
    return sum;
  }
}
