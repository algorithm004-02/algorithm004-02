package datastruct.greedy;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:
 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 说明:
 假设你总是可以到达数组的最后一个位置。

 */
public class JumpGame2 {

    /**
     * 解法一 ：顺藤摸瓜
     LeetCode 讨论里，大部分都是这个思路，贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。
     如下图，开始的位置是 2，可跳的范围是橙色的。然后因为 3 可以跳的更远，所以跳到 3 的位置
     如下图，然后现在的位置就是 3 了，能跳的范围是橙色的，然后因为 4 可以跳的更远，所以下次跳到 4 的位置。

     写代码的话，我们用 end 表示当前能跳的边界，对于上边第一个图的橙色 1，第二个图中就是橙色的 4，遍历数组的时候，到了边界，我们就重新更新新的边界。
     *
     */
     public int canJump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length -1;i++) {
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     *
     * 解法二：顺瓜摸藤
     我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。然后继续找上上个位置，最后到了第 0 个位置就结束了。
     至于离它最远的位置，其实我们从左到右遍历数组，第一个满足的位置就是我们要找的。
     *
     */
    public int jump2(int[] nums) {
        int position = nums.length - 1; // 要找的位置
        int steps = 0;
        while (position != 0) { // 是否到了第 0 个位置
            for (int i = 0; i < position;i++) {
                if (nums[i] >= position - i) {
                    position = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
}
