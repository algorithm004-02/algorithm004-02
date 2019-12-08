package algorithm.LeetCode;

/**
 * describe:
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 作者：vailing
 * 链接：https://leetcode-cn.com/problems/reverse-bits/solution/zuo-you-yi-dong-by-vailing/
 * @author lixilong
 * @date 2019/10/29
 */
public class _190_uint32_treverseBits {


  // 每次将原来的数字向左移动1位，就需要把该末尾加到我们的数字中去即可
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) { //不能判断到原来的数字为0就结束循环，这样就有可能的导致没有补足0所以要循环32次。
      res <<= 1;
      res += n & 1;
      n >>= 1;//对于左移而言，末尾全部补上的是0，而对于右移而言左边补的是原本最高位的数字
    }
    return res;
  }


}
