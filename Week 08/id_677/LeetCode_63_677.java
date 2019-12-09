/*
 * Copyright [2020]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class LeetCode_63_677 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{ {0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        ISolution s = new Solution();
        int ans = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);

        obstacleGrid = new int[][] {{1}};
        ans = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);

        obstacleGrid = new int[][] {{0, 0}};
        ans = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);

        ISolution s2 = new Solution2();
        s2.uniquePathsWithObstacles(obstacleGrid);
        ans = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);

        obstacleGrid = new int[][] {{0, 0, 0}};
        ans = s2.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
}

interface ISolution {
    int uniquePathsWithObstacles(int[][] obstacleGrid);
}

/**
 * recursion with memo
 */
class Solution implements ISolution {
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        final int M = obstacleGrid.length;
        final int N = obstacleGrid[0].length;

        // define dp state : dp[m[n] means at point [m,n] path cnt
        int[][] dp = new int[M][N];

        // init dp state
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = i == 0 ? 1 : dp[i - 1][0];
            }
        }
        for (int i = 0; i < N; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = i == 0 ? 1 : dp[0][i - 1];
            }
        }

        if (M == 1 || N == 1) {
            return dp[M - 1][N - 1];
        }

        for (int m = 1; m < M; m++) {
            for (int n = 1; n < N; n++) {
                if (obstacleGrid[m][n] == 0) {
                    dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
                } else {
                    dp[m][n] = 0;
                }
            }
        }

        return dp[M - 1][N - 1];
    }
}

/**
 * space complexity : O(N)
 */
class Solution2 implements ISolution {
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid[0].length;
        int[] dp = new int[N];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[N - 1];
    }
}
