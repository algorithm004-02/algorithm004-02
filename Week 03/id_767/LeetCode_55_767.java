package algorithm.LeetCode;

/**
 * describe:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 作者：LeetCode
 *   链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
 * @author lixilong
 * @date 2019/11/03
 */
public class _55_canJump {

  //方法1：回溯
  public boolean canJumpFromPosition(int position, int[] nums) {
    if (position == nums.length - 1) {
      return true;
    }

    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      if (canJumpFromPosition(nextPosition, nums)) {
        return true;
      }
    }

    return false;
  }

  public boolean canJump(int[] nums) {
    return canJumpFromPosition(0, nums);
  }


  //方法 2：自顶向下的动态规划
  enum Index {
    GOOD, BAD, UNKNOWN
  }

  Index[] memo;

  public boolean canJumpFromPosition(int position, int[] nums) {
    if (memo[position] != Index.UNKNOWN) {
      return memo[position] == Index.GOOD ? true : false;
    }

    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      if (canJumpFromPosition(nextPosition, nums)) {
        memo[position] = Index.GOOD;
        return true;
      }
    }

    memo[position] = Index.BAD;
    return false;
  }

  public boolean canJump(int[] nums) {
    memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD;
    return canJumpFromPosition(0, nums);
  }


}
