package week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/17 17:04
 * https://leetcode-cn.com/problems/coin-change
 */
public class L322 {
  /**
   * 零钱兑换问题.
   * 1、广度优先遍历
   * */
  public int coinChange(int[] coins, int amount) {
    Queue<Integer> queue = new LinkedList<>();
    int level = 0;
    queue.offer(amount);
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      while (size-- > 0) {
        int e = queue.poll();
        if (e == 0) {
          return level - 1;
        } else if (e < 0) {
          continue;
        } else {
          for (int i = 0; i < coins.length; i++) {
            queue.offer(e - coins[i]);
          }
        }
      }
    }
    return -1;
  }

  /**
   * 递归，深度优先遍历
   * */

  int level = Integer.MAX_VALUE;

  public int coinChange1(int[] coins, int amount) {
    dfs(amount, coins, 0);
    return level == Integer.MAX_VALUE ? -1 : level;
  }

  private void dfs(int amount, int[] coins, int i) {
    if (amount == 0) {
      if (level > i) {
        level = i;
      }
      return;
    }
    if (amount < 0) {
      return;
    }
    for (int j = 0; j < coins.length; j++) {
      dfs(amount - coins[j], coins, i + 1);
    }
  }

  /**
   * dp凑到amount的数值的coin个数 =  min(f(amount-k)) + 1, k是coins里的值.
   * */
  public int coinChange2(int[] coins, int amount) {
    // 数组下标就是钱，数组值表示凑到这个钱需要的最小硬币数.
    int[] dp = new int[amount+1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
