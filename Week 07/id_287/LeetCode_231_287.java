package com.tulane.leetcode.one;

/**
 * 2的幂
 * Created by Tulane
 * 2019/12/1
 */
public class LeetCode_231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
