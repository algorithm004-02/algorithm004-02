import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @Author: Yangjing
 * @Date: 2019/10/20
 */
public class TwoSum {
	/**
	 * @Description: 方法1：双重循环，找到数据中对应的元素
	 * @param nums  给定的整数数组
	 * @param target 给定的目标值
	 * @Author: Yangjing
	 * @Date: 2019/10/20
	 */
	public int[] solutionV1(int[] nums, int target) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if ((nums[i]+nums[j]) == target) {
					return new int[] {i, j};
				}
			}
		}

		return new int[]{};
	}

	/**
	 * @Description: 把遍历的值放入哈希表，一次遍历找到对应的元素
	 * @param nums  给定的整数数组
	 * @param target 给定的目标值
	 * @return
	 * @Author: Yangjing
	 * @Date: 2019/10/20
	 */
	public int[] solutionV2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[]{map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{};
	}
}
