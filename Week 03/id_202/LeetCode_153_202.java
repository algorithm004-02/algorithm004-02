package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 17:02
 * @description
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_153_202 {
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        //有序。。。。
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                //左有序
                //搜右边
                left = mid + 1;
            } else {
                //右有序，搜左边
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums1 = {5,6,2,3,4};
        int[] nums2 = {4,5,6,2,3};
        System.out.println(LeetCode_153_202.findMin(nums));
        System.out.println(LeetCode_153_202.findMin(nums1));
        System.out.println(LeetCode_153_202.findMin(nums2));

    }
}
