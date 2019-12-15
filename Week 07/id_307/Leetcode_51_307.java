class Solution {
    private int N;
    private int[] rows;
    private int[] hills;
    private int[] delas;
    private int[] queens;
    private List<List<String>> results = new ArrayList<>();

    public boolean isOccupied(int row, int col) {
        int constant = rows[col] + hills[row - col + 2 * N] + delas[row + col];
        return constant > 0;
    }

    public void placeQueen(int row, int col) {
        rows[col] = 1; //该行已放置
        hills[row - col + 2 * N] = 1; //左斜
        delas[row + col] = 1; //右斜
        queens[row] = col; //记录放置位置
    }

    public void removeQueen(int row, int col) {
        rows[col] = 0;
        hills[row - col + 2 * N] = 0;
        delas[row + col] = 0;
        queens[row] = 0;
    }

    public void nQueensByDfs(int n, int limit) {
        if (n == limit) {
            List<String> rect = new ArrayList<>();
            for (int i = 0; i < limit; i++) {
                StringBuilder builder = new StringBuilder();
                int col = queens[i];
                for (int j = 0; j < col; j++) {
                    builder.append('.');
                }
                builder.append('Q');
                for (int j = col + 1; j < limit; j++) {
                    builder.append('.');
                }
                rect.add(builder.toString());
            }
            results.add(rect);
            return;
        }

        for (int j = 0; j < limit; j++) {
            if (!isOccupied(n, j)) {
                placeQueen(n, j);
                nQueensByDfs(n + 1, limit);
                removeQueen(n, j);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        hills = new int[4 * n];
        delas = new int[2 * n];
        queens = new int[n];
        N = n;
        nQueensByDfs(0, n);
        return results;
    }
}