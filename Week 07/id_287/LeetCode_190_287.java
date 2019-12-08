package com.tulane.leetcode.one;

/**
 * 颠倒二进制位
 * Created by Tulane
 * 2019/12/1
 */
public class LeetCode_190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
