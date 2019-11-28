package src.main.java.com.fans.algorithm00402.week5.homework;

/**
 * 最大正方形
 */
public class LeetCode_221_232 {
    /**
     * 暴力法
     */
//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length;
//        int cols = rows > 0 ? matrix[0].length : 0;
//        int maxLens = 0;
//        for (int i = 0; i < rows; i ++) {
//            for (int j = 0; j < cols; j ++) {
//                if (matrix[i][j] == '1') {
//                    int lens = 1;
//                    boolean tag = true;
//                    while (lens + i < rows && lens + j < cols && tag) {
//                        for (int k = i; k <= lens + i; k ++) {
//                            if (matrix[k][j + lens] == '0') {
//                                tag = false;
//                                break;
//                            }
//                        }
//
//                        for (int k = j; k <= lens + j; k ++) {
//                            if (matrix[i + lens][k] == '0') {
//                                tag = false;
//                                break;
//                            }
//                        }
//
//                        if (tag)
//                            lens ++;
//                    }
//                    maxLens = Math.max(lens, maxLens);
//                }
//            }
//        }
//        return maxLens * maxLens;
//    }

    /**
     * dp
     *  a. 子问题
     *      - f(n, m) = min(f(n - 1,m), f(n - 1, m - 1), f(n, m - 1)) + 1;
     *  b. dp数组
     *      - dp[n][m]
     *  c. dp方程
     *      - dp[n][m] = min(dp[n - 1][m], dp[n - 1][m - 1], dp[n][m - 1])
     */
//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length;
//        int cols = rows > 0 ? matrix[0].length : 0;
//        if (rows == 0) return 0;
//        int[][] dp = new int[rows + 1][cols + 1];
//        int maxLens = 0;
//        for (int i = 1; i <= rows; i ++) {
//            for (int j = 1; j <= cols; j ++) {
//                if (matrix[i - 1][j - 1] == '1' && i != 0 && j != 0) {
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
//                    maxLens = Math.max(maxLens, dp[i][j]);
//                }
//            }
//        }
//        return maxLens * maxLens;
//    }

    /**
     * dp优化空间
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 0) return 0;
        int pre = 0;
        int[] dp = new int[cols + 1];
        int maxLens = 0;
        for (int i = 1; i <= rows; i ++) {
            for (int j = 1; j <= cols; j ++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1' && i != 0 && j != 0) {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), pre) + 1;
                    maxLens = Math.max(maxLens, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return maxLens * maxLens;
    }
}
