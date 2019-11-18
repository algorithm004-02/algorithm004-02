package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 15:21
 * @description 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_45_202 {

    public static int jump(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //保留本次跳的选择当中最大的index，选择都选择完后需要更新一下
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums1 = {0};
        int[] nums2 = {2, 3, 1, 1, 4};
        int[] nums3 = {3, 2, 1};
        System.out.println(LeetCode_45_202.jump(nums));
        System.out.println(LeetCode_45_202.jump(nums1));
        System.out.println(LeetCode_45_202.jump(nums2));
        System.out.println(LeetCode_45_202.jump(nums3));
    }
}
