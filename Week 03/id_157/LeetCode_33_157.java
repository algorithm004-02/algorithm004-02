package com.kaiyun.leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-11-01 09:10
 * 简要来说：
 *
 * nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；
 *
 * nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）
 *
 * nums[mid] < nums[0]，nums[mid] < nums[0] <= target 时向前规约（target 在 0 到旋转位置之间）
 *
 * 其他情况向后规约
 *
 * 也就是说nums[mid] < nums[0]，nums[0] > target，target > nums[mid] 三项均为真或者只有一项为真时向后规约。
 *
 * 作者：LukeLee
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class LeetCode_33_157 {
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if ((nums[mid] < nums[l]) ^ (nums[l] > target) ^ (nums[mid] < target)) {
                l = mid + 1;
            } else {
               r = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找旋转点
     *
     * 这个算法只适合数组有序，或半有序，不适合完全无序的情况。但算法总体感觉很啰嗦
     * @param nums
     * @return
     */
    public static int searchTheRotatedPoint(int[] nums) {
        // 如果nums为一个元素，我们认为数组是有序的，返回-1
        if (nums.length <= 1) return -1;
        int l= 0, r = nums.length - 1;
        // 开始二分查找
        while (l <= r) {
            int mid = (r + l) / 2;
            // 如果查找的中间元素大于后一个元素，说明后一个元素就是旋转点
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
                // 如果查找的中间元素小于前一个元素，说明当前元素就是旋转点
            } else if(nums[mid] < nums[mid - 1]) {
                return mid;
                // 如果中间元素大于最右边元素，则向右规约
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
                // 如果中间元素小于最左边元素，则向左规约
            } else if (nums[mid] < nums[l]){
                r = mid - 1;
                // 其他情况则说明数组有序
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9,4,8,0,10,3,19};

        System.out.println(search(nums,3));
        System.out.println(searchTheRotatedPoint(nums));
    }
}
