package src.main.java.com.fans.algorithm00402.week3.homework;

/**
 * 寻找旋转排序数组中的最小数
 */
public class LeetCode_153_232 {
    /**
     * 1. 暴力法
     */
//    public int findMin(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i ++) {
//            min = Math.min(nums[i], min);
//        }
//        return min;
//    }

    /**
     * 2. 二分查找
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        int fix = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid - 1 >= 0 && nums[mid - 1] > nums[mid])) fix = mid;
            if (nums[mid] >= nums[0] && nums[mid] >= nums[nums.length - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return nums[fix];
    }

    /**
     * 3. 还可以排序输出第一个
     */
}
