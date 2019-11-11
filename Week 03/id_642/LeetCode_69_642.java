package week3.practice;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/31 13:27
 * https://leetcode-cn.com/problems/sqrtx
 */
public class L69 {
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    long left = 1L;
    long right = (long) x / 2;
    while (left < right) {
      /** 要取右中位数，否则可能死循环 */
      long mid = (right + left + 1) >> 1;
      long sq = mid * mid;
      if (sq > x) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return (int)left;
  }

  public static void main(String[] args) {
    L69 l69 = new L69();
    System.out.println(l69.mySqrt(8));
  }
}
