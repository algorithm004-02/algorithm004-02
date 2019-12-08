package src.main.java.com.fans.algorithm00402.week3.homework;

import java.util.Arrays;

/**
 * 搜索旋转排序数组
 */
class LeetCode_33_232 {

    /**
     * 暴力法
     *  - 先找到旋转位置 O（logN）
     *  - 给数组排序
     *  - 二分查找有序数组，得到结果加上旋转位置 余上数组长度
     */
//    public int search(int[] nums, int target) {
//        // 找到旋转位置
//        int left = 0;
//        int right = nums.length - 1;
//        int fix = 0;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if ((mid - 1 >= 0 && nums[mid - 1] > nums[mid])) fix = mid;
//            if (nums[mid] >= nums[0] && nums[mid] >= nums[nums.length - 1]) left = mid + 1;
//            else right = mid - 1;
//        }
//
//        Arrays.sort(nums);
//
//        left = 0;
//        right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) return (mid + fix) % nums.length;
//            if (nums[mid] > target) right = mid - 1;
//            else left = mid + 1;
//        }
//        return -1;
//    }

    /**
     * 2. 二分查找
     */
//    public int search(int[] nums, int target) {
//        if (nums.length == 0) return -1;
//        if (target == nums[0]) return 0;
//        if (target == nums[nums.length - 1]) return nums.length - 1;
//
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) return mid;
//            if (nums[mid] >= nums[0] && nums[mid] >= nums[nums.length - 1]) {
//                // mid 在大的半边, 也就是左半边
//                if (target > nums[0]) {
//                    if (target > nums[mid]) left = mid + 1;
//                    else right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            else {
//                // mid 在小的半边， 右半边
//                if (target > nums[nums.length - 1]) {
//                    right = mid - 1;
//                } else {
//                    if (target > nums[mid]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    /**
     * 3. 优美的二分
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        LeetCode_33_232 code = new LeetCode_33_232();
        System.out.println(code.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
