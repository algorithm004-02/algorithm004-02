package week2.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/27 10:30
 *
 * https://leetcode-cn.com/problems/powx-n/
 * pow(x, n)
 */
public class L50 {
  /**
   * 分治
   *
   * f(x, n) = f(x, n/2) * f(x, n/2)
   * */
  public double myPow(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = 0 - n;
    }
    double result = subMyPow(x, n);
    return result;
  }

  public double subMyPow(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    if (n == 1) {
      return x;
    }
    double half = subMyPow(x, n / 2);
    return n % 2 == 0 ?  half * half : half * half * x;
  }
}
