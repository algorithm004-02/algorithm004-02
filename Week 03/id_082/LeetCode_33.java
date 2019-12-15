/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 *
 * @author yangjing
 * @version v1.0
 */
public class LeetCode33 {

	/**
	 * 升序数组虽然发生了旋转，但是二分之后，至少一半还保留着有序，根据这个规律来二分查找
	 * 目标数值
	 * @param nums  升序数组旋转之后的数组
	 * @param target 查找的目标值
	 * @return
	 */
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left+right)/2;
			if (nums[mid] == target) {
				return mid;
			}

			// 前半部分有序
			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid-1;
				} else {
					left = mid+1;
				}
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid+1;
				} else {
					right = mid-1;
				}
			}
		}

		return left==right && nums[left] == target ? left:-1;
	}
}
