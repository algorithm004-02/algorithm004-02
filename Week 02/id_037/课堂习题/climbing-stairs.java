// https://leetcode-cn.com/problems/climbing-stairs/
// 递归
// 这里写的比较啰嗦，是为了强行理解之前的递归代码套路
class Solution {
    public int climbStairs(int n) {
        // termination codition
        if (n < 3) return n;
        // drill down
        int p = climbStairs(n -1);
        int q = climbStairs(n - 2);
        // current logic
        int curr = p + q;
        return curr;
        // revert state
    }
}