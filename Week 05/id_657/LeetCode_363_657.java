package com.arithmetic.arithmetic.week05;

public class LeetCode_363_657 {
    int[][] prefixSums;
    int R, C;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        init(matrix);
        int maxSum = Integer.MIN_VALUE;
        for (int r0 = 0; r0 < R; ++r0) {
            for (int c0 = 0; c0 < C; ++c0) {
                for (int r1 = r0; r1 < R; ++r1) {
                    for (int c1 = c0; c1 < C; ++c1) {
                        int sum = getRectSum(r0, c0, r1, c1);
                        if (sum <= k) {
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }
            }
        }
        return maxSum;
    }

    private void init(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        prefixSums = new int[R+1][C+1];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                prefixSums[r+1][c+1] = prefixSums[r+1][c] + matrix[r][c];
            }
        }

        for (int c = 0; c <= C; ++c) {
            for (int r = 0; r < R; ++r) {
                prefixSums[r+1][c] += prefixSums[r][c];
            }
        }
    }

    private int getRectSum(int r0, int c0, int r1, int c1) {
        return prefixSums[r1+1][c1+1] - prefixSums[r1+1][c0] - prefixSums[r0][c1+1] + prefixSums[r0][c0];
    }
}
