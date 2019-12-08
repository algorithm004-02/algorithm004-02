package com.algorithm.qinchao.homework.week05;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/14 13:50
 * @description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_322_202 {
    /**
     * 子问题：f(i) = min(f(amout-coin(i),f(i)])+1,每一个金额的兑换用的coins里面的最小值赋予本次的金额兑换
     * 状态函数：result[i] 每个金额本次兑换的最少兑换次数
     * dp方程：f[n] = min[]
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeByDp(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        //标志位表示刚好兑换完
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    //获取每个coins可以兑换的面值的兑换次数，然后得到本次金额使用兑换次数最少的面值
                    result[i] = Math.min(result[i], result[i - coin] + 1);
                }
            }
        }
        return result[amount] == amount + 1 ? -1 : result[amount];
    }

    public static int coinChangeByBFS(int[] coins, int amount) {
        if (coins.length == 1 && coins[0] == amount) {
            return 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(amount);
        int result = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                Integer tempAmount = queue.poll();
                if (tempAmount == 0) {
                    flag = true;
                    break;
                }
                getNext(tempAmount, queue, coins);
            }
            if (flag == true) {
                break;
            }
            if (!queue.isEmpty()) {
                result++;
            }
        }
        return flag ? result : -1;
    }

    private static void getNext(Integer tempAmount, LinkedList<Integer> queue, int[] coins) {
        for (int coin : coins) {
            if (coin <= tempAmount) {
                queue.add(tempAmount - coin);
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(LeetCode_322_202.coinChangeByDp(coins, 11));
        System.out.println(LeetCode_322_202.coinChangeByBFS(coins, 11));
    }
}
