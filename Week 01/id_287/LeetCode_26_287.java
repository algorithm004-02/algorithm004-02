package com.tulane.homework;

/**
 * @title  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * Created by Tulane
 * 2019/10/20
 */

/**
 * 重点: 排序后的数组, 即后一个下标的数不会比当前的大 & 重复数组, 需要跳指针
 * 思路: 使用移动零的思路解题, 双指针移动交换
 */
public class LeetCode_26_287 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new LeetCode_26_287().removeDuplicates(nums));
    }

    /**
     * 第二种 快慢指针 优化第一种
     * 同样双指针 但其实j无需重置, 因为数组已排序
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = i;
        while (i <= nums.length - 1 && (i == 0 || nums[i] > nums[i - 1])) {
            //将j位置的数交换为右最相邻的大于i数值的数
            while ((j < nums.length - 1) && nums[++j] <= nums[i]);
            //有可能满足了第一个条件结束的循环, 需再次判断是否是大于i数值的 TODO 可优化:判断当前j是否等于i+1, 若是则不必交换
            if (nums[j] > nums[i]) {
                nums[i + 1] = nums[j];
            }
            // 右移i
            i++;
        }
        return i;
    }

    /**
     * 第一种 双指针, 指针i从0下标开始, 指针j从i+1开始
     * 不断右移j 比对i与j的数值是否相等:
     * 1. 不相等并且大于i数值, 则说明i指针的数非重复, i右移并重置j
     * 2. 相等则需要将j的位置替换为"紧接着"的一个"不相等"的下标的值
     *
     * 附: j右移中, 当j的值大于i的值, 说明后续也没有与i数值重复的, 即可右移i进行下个循环
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {

        int i = 0;
        while (i <= nums.length - 1 && (i == 0 || nums[i] > nums[i - 1])) {
            int j = i;
            //将j位置的数交换为右最相邻的大于i数值的数
            while ((j < nums.length - 1) && nums[++j] <= nums[i]);
            //有可能满足了第一个条件结束的循环, 需再次判断是否是大于i数值的 TODO 可优化:判断当前j是否等于i+1, 若是则不必交换
            if (nums[j] > nums[i]) {
                nums[i + 1] = nums[j];
            }
            // 右移i
            i++;
        }
        return i;
    }
}
