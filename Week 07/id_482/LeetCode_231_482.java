package com.study.week7.lesson14;

public class LeetCode_231_482 {

    /**
     * 2 的整数次幂 只有一位为1；
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1)) == 0;
    }
}
