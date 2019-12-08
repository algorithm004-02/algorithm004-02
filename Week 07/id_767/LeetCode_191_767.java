package algorithm.LeetCode;

import java.util.Scanner;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _191_HammingWeight {



  //方法 2：位操作的小技巧
  //位运算 计数
  public int hammingWeight2(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);////每次运算后的n,后面位为0，只需要统计前面未统计的
    }
    return sum;
  }


  // Runtime: 1 ms, faster than 91.13%
  // 方法 1：循环和位移动
  public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        bits++;//掩码作为统计1的个数，从最右边不断的左移直到首尾。
      }
      mask <<= 1;
    }
    return bits;
  }



  /**
   * describe:
   *时间限制：1秒 空间限制：32768K 热度指数：308489
   链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/

   * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
   * @author lixilong
   * @date 2019/01/10
   */
  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
//    System.out.println(hammingWeight(in));
  }

}
