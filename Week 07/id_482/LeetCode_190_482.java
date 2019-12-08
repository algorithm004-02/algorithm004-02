package com.study.week7.lesson14;

public class LeetCode_190_482 {

    public int reverseBits(int n) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) +(n & 1);
            n >>=1;
        }
        return ans >>>0;
    }
}
