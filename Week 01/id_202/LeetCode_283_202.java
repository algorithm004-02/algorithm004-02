package com.algorithm.qinchao.homework.week01;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/18 09:44
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_283_202 {
    /**
     * @param nums
     * @description 时间复杂度 = O(n+m)
     */
    public static void moveZeroesPlaceholder(int[] nums) {
        int slowIndex = 0;
        //先将非0的占位在数组前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slowIndex++] = nums[i];
            }
        }
        //然后补0
        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * @param nums
     * @description 时间复杂度 = O(n)
     */
    public static void moveZeroesByZero(int[] nums) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slowIndex++] = nums[i];
                //两个不等了证明有0的发生了，不然不交换
                if (slowIndex - 1 != i) {
                    nums[i] = 0;
                }
            }
        }
    }

    /**
     * @param nums
     * @description 时间复杂度 = O(n)
     */
    public static void moveZeroesBySwap(int[] nums) {
        int slowIndex = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[slowIndex++];
                nums[slowIndex - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        LeetCode_283_202.moveZeroesPlaceholder(nums);
        System.out.println(ToStringBuilder.reflectionToString(nums));
        int nums2[] = {0, 1, 0, 3, 12};
        LeetCode_283_202.moveZeroesByZero(nums2);
        System.out.println(ToStringBuilder.reflectionToString(nums2));
        int nums3[] = {1, 0, 2};
        LeetCode_283_202.moveZeroesBySwap(nums3);
        System.out.println(ToStringBuilder.reflectionToString(nums3));
    }
}
