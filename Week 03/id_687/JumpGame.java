package com.itliusir.array;

/**
 * problem.55
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author liugang
 * @date 2019-11-03
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame().canJump(nums));
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * 逆向贪心
     *
     * @author liugang
     * @date 2019-11-03 23:16:23
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * 正向贪心
     *
     * @author liugang
     * @date 2019-11-03 23:16:49
     */
    public boolean canJumpTwo(int[] nums) {
        if (nums == null) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
