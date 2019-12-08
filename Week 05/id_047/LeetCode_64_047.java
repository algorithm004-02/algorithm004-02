public class LeetCode_64_047 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[r - 1][c - 1] = grid[r - 1][c - 1];
        //init last row
        for (int i = c - 2; i >= 0; i --) {
            dp[r - 1][i] = dp[r - 1][i + 1] + grid[r - 1][i];
        }
        //init last column
        for (int i = r - 2; i >= 0; i --) {
            dp[i][c - 1] = dp[i + 1][c - 1] + grid[i][c - 1];
        }

        if (r == 1 || c == 1) {
            return dp[0][0];
        }

        for(int i = r - 2; i >= 0; i --) {
            for(int j = c - 2; j >= 0; j --) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
