package Week7;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/28 07:17
 * https://leetcode-cn.com/problems/power-of-two
 */
public class L231 {
  /**
   * 2的幂.
   * */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && ((n & (n - 1)) == 0);
  }
}
