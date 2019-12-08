package com.itliusir.array;

/**
 * problem.26
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author liugang
 * @date 2019-10-20
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicates().removeDuplicatesTwo(nums));
    }

    /**
     * method 1 -> time O(n) space O(1)
     * <p>
     * 双指针解法
     *
     * @author liugang
     * @date 2019-10-20 02:16:45
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];

            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * method 2 -> time O(n) space O(1)
     * <p>
     * 若前后不相同则更新index，单指针记录处理后数据
     *
     * @author liugang
     * @date 2019-10-20 02:21:35
     */
    public int removeDuplicatesTwo(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (index == 0 || num > nums[index - 1]) {
                nums[index++] = num;
            }
        }
        return index;
    }
}
