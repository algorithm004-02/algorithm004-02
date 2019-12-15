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


public class LeetCode_72_677 {
    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";
        ISolution s1 = new Solution1();
        int ans = s1.minDistance(w1, w2);
        System.out.println(ans);

        w1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        w2 = "ultramicroscopically";
        ans = s1.minDistance(w1, w2);
        System.out.println(ans);
    }
}

interface ISolution {
    int minDistance(String word1, String word2);
}

/**
 * DP
 * 1/ define DP state
 * 2/ induct DP formula
 */
class Solution1 implements ISolution {
    @Override
    public int minDistance(String word1, String word2) {
        int M = word1 == null ? 0 : word1.length();
        int N = word2 == null ? 0 : word2.length();
        if (M * N == 0) {
            return M + N;
        }
        int[][] dp = new int[M + 1][N + 1];

        // init
        for (int i = 0; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // 三者之中取最小者(对角线需判断当前的两个字符是否相等)
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) left_down += 1;
                dp[i][j] = Math.min(left_down, Math.min(left, down));
            }
        }
        return dp[M][N];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // if one of the strings is empty
        if (n * m == 0)
            return n + m;

        // array to store the convertion history
        int [][] d = new int[n + 1][m + 1];

        // init boundaries
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }

        // DP compute
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                d[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return d[n][m];
    }
}

class Solution2 implements ISolution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // if one of the strings is empty
        if (n * m == 0)
            return n + m;

        // array to store the convertion history
        int [][] d = new int[n + 1][m + 1];

        // init boundaries
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }

        // DP compute
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                d[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return d[n][m];
    }
}
