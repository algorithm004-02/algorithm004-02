/**
 * 寻找旋转排序数组中的最小值
 * Created by yangwenwei on 2019/11/1.
 */
public class LeetCode_153_597 {
    public static void main(String[] args) {
        new Solution().findMin(new int[]{4, 5, 6, 7, 2, 3});
    }

    static class Solution {
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                //最小值在左半边
                // 不为常规的mid-1,因为每次二分需要将数组分为[0,mid][mid+1,nums.length-1].
                // 如果hi=mid - 1,则会忽略了mid的元素.
                // 常规的mid-1,因为在循环内处理了mid的值,所以可以mid-1
                if (nums[mid] < nums[hi]) hi = mid;
                    //最小值在右半边
                else if (nums[mid] > nums[hi]) lo = ++mid;
            }
            return nums[lo];
        }
    }
}
