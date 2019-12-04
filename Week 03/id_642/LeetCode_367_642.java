package week3.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/2 09:41
 * https://leetcode-cn.com/problems/valid-perfect-square
 */
public class L367 {
  public boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    long lnum = (long) num;
    long left = 1L;
    long right = lnum / 2;
    while (left <= right) {
      long mid = (right + left) >> 1;
      long sq = mid * mid;
      if (sq == lnum) {
        return true;
      } else if (sq > lnum) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }
}
