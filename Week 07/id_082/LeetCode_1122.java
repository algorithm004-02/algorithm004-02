import java.util.TreeMap;

/**
 * 给你两个数组，arr1 和 arr2，
 *  arr2 中的元素各不相同
 *  arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @version v1.0
 */
public class LeetCode_1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		TreeMap<Integer, Integer> bucket = new TreeMap<>();
		int[] result = new int[arr1.length];
		for (int i=0; i<arr1.length; i++) {
			int count = bucket.getOrDefault(arr1[i], 0);
			bucket.put(arr1[i], count+1);
		}
		int i=0;
		for (int j=0; j<arr2.length; j++) {
			int count = bucket.getOrDefault(arr2[j], 0);
			while (count > 0) {
				result[i++] = arr2[j];
				count--;
			}
			bucket.remove(arr2[j]);
		}
		for (int n:bucket.keySet()) {
			int count = bucket.getOrDefault(n, 0);
			while (count>0) {
				result[i++] = n;
				count--;
			}
		}
		return result;
	}
}
