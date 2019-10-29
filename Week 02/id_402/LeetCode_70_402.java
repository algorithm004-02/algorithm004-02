class Solution {
    //关键思想，进行最小子问题抽象，使用归纳法，抽象成为斐波那契问题
    public int climbStairs(int n) {
        return sum(n);
    }

    public int sum(int n){
        if( n == 1) return 1;
        if(n == 2) return 2;
        return sum(n-1)+sum(n-2);
    }
}