// https://leetcode-cn.com/problems/climbing-stairs/
// 这类题目我们线列举一些简单的，人脑可以穷举的情形
// 阶梯数 1:
//         1 跨一步
// 阶梯数 2:
//         1 1阶 + 1 阶
//         3 2阶
// 阶梯数 3：
//         1 1阶 + 1阶 + 1阶
//         2 1阶 + 2阶
//         3 2阶 + 1阶
// 当阶梯数为更多时，我们发现上n阶楼梯
//     1 从第n-1阶上跨1阶上来
//     2 从第n-2阶上跨2阶上来
//     所以我们得到一个通项公式 f(n) = f(n-1) + f(n-2)
// 有了通项公式，我们就可以用表现力强的递归去解决，在不加任何缓存的情况下复杂度较高是O(N^k)
// 所以我们手动的去做每次的递归操作

// 1 暴力递归
class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// 2 手动递归循环推进
// 其实该题目是一个斐波拉契数列
class Solution2 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        int iteration = 3;
        while ( iteration<=n ) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
            iteration++;
        }
        return f3;

    }
}