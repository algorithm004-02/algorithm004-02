/**
 * 搜索旋转排序数组
 * Created by yangwenwei on 2019/11/1.
 */
public class LeetCode_33_597 {

    class Solution {

        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (nums[mid] == target) return mid;
                //mid左边是升序的,且target不在左边
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) lo = mid + 1;
                    //mid左边有旋转位
                else if (target > nums[mid] && target < nums[0]) lo = mid + 1;
                else hi = mid - 1;

            }
            return -1;
        }
    }
}
