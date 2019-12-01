package com.arithmetic.arithmetic.week07;

public class LeetCode_190_657 {
    public int reverseBits(int n) {
        int i = 0, j = 31, retVal = 0, temp;
        while (i < j) {
            temp = n >> i;
            temp &= 1;
            temp <<= j;
            retVal |= temp;
            temp = n >> j;
            temp &= 1;
            temp <<= i;
            retVal |= temp;
            i++;
            j--;
        }
        return retVal;
    }
}
