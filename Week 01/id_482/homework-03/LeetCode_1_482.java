package com.isshelter.study.week01.a.homework03;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @link
 */
public class LeetCode_1_482 {
    /**
     * 解法1 ：暴力法 （迭代循环）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
