package com.arithmetic.arithmetic.week05;

public class LeetCode_552_657 {
    long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }
}
