package Week7;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/28 07:08
 * https://leetcode-cn.com/problems/hamming-distance
 */
public class L461 {
  /**
   * 汉明距离.
   * */
  public int hammingDistance(int x, int y) {
    int z = x ^ y;
    int count = 0;
    while (z != 0) {
      count++;
      z = z & (z - 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println( 5 & -5);
  }
}
