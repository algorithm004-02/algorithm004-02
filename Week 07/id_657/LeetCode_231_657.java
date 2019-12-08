package com.arithmetic.arithmetic.week07;

public class LeetCode_231_657 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
