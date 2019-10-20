package com.isshelter.study.week01.a.homework03;


/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26_482 {
    /**
     * 解法一:双指针法
     * @param nums
     * @return
     *
     */
    public int removeDuplicates(int[] nums) {
        int slow=0,fast=0;

        while (++fast < nums.length)
            if (nums[slow] != nums[fast])
                nums[++slow]=nums[fast];

        return ++slow;
    }
}
