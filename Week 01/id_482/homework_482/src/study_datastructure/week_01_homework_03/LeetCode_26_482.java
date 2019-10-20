package study_datastructure.week_01_homework_03;

/**
 * @Auther: gd_space@163.com
 * @Date: 2019/10/16
 * @Description: com.isshelter.study.week01.homework03
 * @version: 1.0
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
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
