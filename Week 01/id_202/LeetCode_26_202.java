package com.algorithm.qinchao.homework.week01;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/17 09:54
 * @description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_26_202 {
    int slowIndex = 0;

    /**
     * 快慢指针解法
     * @param nums
     * @return
     * @description 时间复杂度 = O(N)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return slowIndex;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                //不同的时候后面的替换前面的，而不影响后面与再后面的比较
                nums[++slowIndex] = nums[i + 1];
            }
        }
        return slowIndex + 1;
    }


    public static void main(String[] args) {
        LeetCode_26_202 leetCode_26_202 = new LeetCode_26_202();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(leetCode_26_202.removeDuplicates(nums));
        for (int i = 0; i < leetCode_26_202.slowIndex + 1; i++) {
            System.out.println(nums[i]);
        }
    }
}
