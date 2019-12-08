package com.kaiyun.leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-11-03 11:51
 **/
public class LeetCode_153_157 {
    public int findMin(int[] nums) {
        // 如果nums为一个元素，我们认为数组是有序的，返回第一个元素
        if (nums.length == 1) return nums[0];
        int l= 0, r = nums.length - 1;
        // 处理有序的情况
        if (nums[r] > nums[0]) return nums[0];
        // 开始二分查找
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 如果当前元素大于后一个元素，说明后一个元素就是旋转点
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];

            }
            // 如果当前元素小于前一个元素，说明当前元素就是旋转点
            if(nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // 如果当前元素大于最左边元素，则向右规约，否则向左规约
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
