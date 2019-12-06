package src.main.java.com.fans.algorithm00402.week7.homework;

/**
 * n 皇后 2
 */
public class LeetCode_52_232 {

    private int count = 0;
    private int size;
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return count;
    }

    private void dfs(int col, int pie, int na) {
        if (col == size) {
            count ++;
            return;
        }

        int pos = ~(col | pie | na) & size;

        while (pos != 0) {
            int p = pos & -pos;
            pos -= p;
            dfs(col | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
