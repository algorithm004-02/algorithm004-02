package com.study.week6.lesson14;

/**
 * @Auther: gd_space@163.com
 * @Date: 2019/10/14
 * @Description: com.isshelter.a
 * @version: 1.0
 */
public class LeetCode_70_482 {

    public int climbStairs_1(int n) {
        if (n <= 2)
            return n;
        else
            return climbStairs_1(n-1)+climbStairs_1(n-2);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a=1,b=2;int res=0;
        for (int i = 2; i < n; i++) {
            res=b+a;
            a=b;
            b=res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_70_482().climbStairs_1(45));
        System.out.println(new LeetCode_70_482().climbStairs(45));
    }
}
