/**
 * 70. 爬楼梯 
 * 加入数组，记忆已经计算过的。
 */
class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        return fib(n, mem);
    }
    
    public int fib(int n, int[] mem) {
        if (n <= 2) return n;
        if (mem[n] == 0) {
            mem[n] = fib(n-1,mem) + fib(n-2,mem);
        }
        return mem[n];
    }
    
}