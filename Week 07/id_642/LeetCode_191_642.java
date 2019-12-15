package Week7;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/28 06:50
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class L191 {
  /**
   * 二进制中1的个数，也称为汉明重量.
   * 时间复杂度 O(1)，跟n的二进制数有关系，但最大32位.
   * 空间复杂度 O(1)
   * */
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      // 清除最低位的0
      n = n & (n - 1);
    }
    return count;
  }

  /**
   * 解法2：依次遍历统计1的个数
   * */
  public int hammingWeight2(int n) {
    int count = 0;
    int mask = 1;
    /**
     * 从最低位开始依次遍历是不是1.
     * */
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        count++;
      }
      mask = mask << 1;
    }
    return count;
  }
}
