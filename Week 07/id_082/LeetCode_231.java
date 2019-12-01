/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 *
 * 输入: 218
 * 输出: false
 *
 * @version v1.0
 */
public class LeetCode_231 {
	public boolean isPowerOfTwo(int n) {
		return n>0 && ((n&(n-1)) == 0);
	}
}
