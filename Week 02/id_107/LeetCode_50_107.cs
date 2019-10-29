/*
    50. Pow(x, n)
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */

// 解法 1: 递归
// 通过分治的思想, 将问题分解成求解一个个子问题.
public class Solution
{
    public double MyPow(double x, int n)
    {
        // if x is negative, convert n to positive
        if (n < 0)
        {
            x = 1 / x;
            n = -n;
        }

        return FastPow(x, n);
    }

    private double FastPow(double x, int n)
    {
        if (n == 0) return 1.0;

        double half = FastPow(x, n / 2);
        return n % 2 == 0
            ? half * half
            : half * half * x;

    }
}
