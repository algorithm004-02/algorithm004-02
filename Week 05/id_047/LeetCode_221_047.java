public class LeetCode_221_047 {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = rows > 0 ? matrix[0].length : 0;
        int maxSide = 0;
        int prev = 0;
        int[] dp = new int[columns + 1];
        for(int i = 1; i <= rows; i ++) {
            for(int j = 1; j <= columns; j ++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(prev,dp[j]),dp[j - 1]) + 1;
                    maxSide = Math.max(maxSide,dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSide * maxSide;
    }
}
