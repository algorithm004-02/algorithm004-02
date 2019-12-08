/**
 * 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * @version v1.0
 */
public class LeetCode_191 {
	public int hammingWeight(int n) {
		int count=0;
		while (n != 0) {
			count++;
			n &= (n-1);
		}
		return count;
	}

	/**
	 * 递归算法
	 * @param n
	 * @return
	 */
	public int hammingWeightV1(int n) {
		return n!=0 ? 1+hammingWeightV1(n & (n-1)):0;
	}
}
