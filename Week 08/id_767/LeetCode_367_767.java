package algorithm.LeetCode;

/**
 * describe:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _367_IsPerfectSquare {

//  time complexity  O(sqrt(n)),  time complexity is O(log(n)):
//  Runtime: 0 ms, faster than 100.00%



  //  Runtime: 0 ms, faster than 100.00%
  //  牛顿迭代法
  public boolean isPerfectSquare2(int num) {
    long x = num;
    while (x * x > num)
      x = (x + num / x) >> 1;

    return x * x == num;
  }

  //暴力法：二分法加速
  public boolean isPerfectSquare3(int num) {
    int l = 1, r = num;

    while (l < r) {
      int mid = (l + r) /2;
      if (mid * mid < num) l = mid + 1;
      else r = mid;
    }
    return l * l == num;
  }


  /**
   *
   * 有一个公式
   1 + 3 + 5 + 7 + ... (2N-1)= N^2
   所以任意一个平方数可以表示成这样的奇数序列和。*/

  public boolean isPerfectSquare1(int num) {
    int i = 1;
    while (num > 0) {
      num -= i;
      i += 2;
    }
    return num == 0;
  }

  //暴力法：从i开始
  public boolean isPerfectSquare(int num) {
    int i = 1;
    while (i * i < num/2)
          i += 1;
    return i * i == num;
  }

}
