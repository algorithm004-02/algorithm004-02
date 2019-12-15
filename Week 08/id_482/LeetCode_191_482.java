package com.study.week8;

public class LeetCode_191_482 {

    // you need to treat n as an unsigned value
    private int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
