package com.itliusir.dynamic;

/**
 * problem.70
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author liugang
 * @date 2019-10-19
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(new ClimbStairs().climbStairsFour(n));
    }

    /**
     * method 1 -> time O(2^n) space O(n)
     * <p>
     * 经分析 其实是一个求斐波那契
     * 可以使用递归暴力求解
     *
     * @author liugang
     * @date 2019-10-19 11:15:28
     */
    public int climbStairs(int n) {
        if (n > 0 && n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * method 2 -> time O(n) space O(n)
     * <p>
     * 递归+缓存
     *
     * @author liugang
     * @date 2019-10-19 15:44:52
     */
    public int climbStairsTwo(int n) {
        if (n > 0 && n <= 2) {
            return n;
        }
        int[] memoryArray = new int[n + 1];
        memoryArray[1] = 1;
        memoryArray[2] = 2;
        if (memoryArray[n] > 0) {
            return memoryArray[n];
        }
        memoryArray[n] = climbStairsTwo(n - 1) + climbStairsTwo(n - 2);
        return memoryArray[n];
    }

    /**
     * method 3 -> time O(n) space O(n)
     * <p>
     * 根据公式 F(3) = F(2) + F(1)
     *
     * @author liugang
     * @date 2019-10-19 15:51:20
     */
    public int climbStairsThree(int n) {
        if (n > 0 && n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * method 4
     * <p>
     * 类似method 3的公式推导，这里使用动态规划的数组进行存值
     *
     * @author liugang
     * @date 2019-10-19 15:58:28
     */
    public int climbStairsFour(int n) {
        // 多加一点空间 取消n = 1 时的判断
        int dp[] = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
