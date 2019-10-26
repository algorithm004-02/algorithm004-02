import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateArray {
	/**
	 * @Description: 方法1：通过一个临时数组，将 k 转换为数组长度内的移动，
	 * 执行两次批量移动得到移动后的 数组
	 * @param nums  给定的整数数组
	 * @param k     向右移动 K 位
	 * @Author: Yangjing
	 * @Date: 2019/10/20
	 */
	public void rotateV1(int[] nums, int k) {
		if (k > nums.length) {
			k = k%(nums.length);
		}
		int[] res = new int[nums.length];
		System.arraycopy(nums, 0, res, k, nums.length-k);
		System.arraycopy(nums, nums.length-k, res, 0,k);
		System.arraycopy(res, 0, nums, 0, res.length);
	}

	/**
	 * @Description: 方法2：通过一个临时数组，循环得到源数组得到新数组每个位的值
	 * @param nums  给定的整数数组
	 * @param k     向右移动 K 位
	 * @Author: Yangjing
	 * @Date: 2019/10/20
	 */
	public void rotateV2(int[] nums, int k) {
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i+k)%nums.length] = nums[i];
		}
		System.arraycopy(a, 0, nums, 0, a.length);
	}
}
