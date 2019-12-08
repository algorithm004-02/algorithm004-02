public class LeetCode_62_677 {
    
    public static void main(String[] args) {
        LeetCode_62_677 solution = new LeetCode_62_677();
        int ans = solution.uniquePaths(7, 3);
        System.out.println(ans);
    }

    public int uniquePaths(int m, int n) {
        int[][] state = new int[m][n];

        for (int i = 0; i < m; i++) {
            state[i][n -1] = 1;
        }
        for (int i = 0; i < n; i++) {
            state[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                state[i][j] = state[i][j + 1] + state[i + 1][j];
            }
        }

        return state[0][0];

        // 问题分解 problem(i, j) = sub(i, j + 1) + sub(i + 1, j)

        // 二位数组定义状态 state[i, j]

        // DP方程 problem(i, j) = problem(i, j + 1) + problem(i + 1, j)
    }
}
