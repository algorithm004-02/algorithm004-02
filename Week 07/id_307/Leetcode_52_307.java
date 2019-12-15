class Solution {
    private int count;
    private void totalNQueensByDfsWithBin(int n, int limit, int rows, int hills, int dales) {
        if (n >= limit) {
            count++;
            return;
        }
        // int pos = rows[n] + hills[row - col + 2 * n] + dales[row + col];
        // 下面都使用 1字节有符号整型来设例。
        // 这里直接整体上运算一次，最后看 n 的位置是否为 1 （已经求反）
        int free_cols = ~(rows | hills | dales) & ((1 << limit) - 1);
        // 有位置可以使用（0000(2) => 0(10):没有位置，1111 => 15(10):所有位置可用)
        while (free_cols != 0) {
            // 取得放置后的位置 00001110 & 10001110(反码加1后为 00000010) ：1110 & 0010 => 0010
            int cur_cols = free_cols & -free_cols;
            // 通过函数参数固定放置结果
            totalNQueensByDfsWithBin(n + 1, limit, rows | cur_cols, (hills | cur_cols) << 1, (dales | cur_cols) >> 1);
            free_cols = free_cols & (free_cols - 1);
        }
    }
    public int totalNQueens(int n) {
        count = 0;
        totalNQueensByDfsWithBin(0, n, 0, 0, 0);
        return count;
    }
}