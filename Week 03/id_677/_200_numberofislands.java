
public class _200_numberofislands {
    public static void main(String[] args) {
        char[][] canvas = new char[][]{"11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(), "00000".toCharArray()};
        ISolution s1 = new Solution1();
        int cnt = s1.numIslands(canvas);
        System.out.println(cnt);

        canvas = new char[][] {"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};
        cnt = s1.numIslands(canvas);
        System.out.println(cnt);

        canvas = new char[][]{};
        cnt = s1.numIslands(canvas);
        System.out.println(cnt);

    }
}

interface ISolution {
    int numIslands(char[][] grid);
}

/**
 * DFS 冲水法更形象
 * time complexity : O(X * Y)
 */
class Solution1 implements ISolution {
    int X = Integer.MIN_VALUE;
    int Y = Integer.MIN_VALUE;
    @Override
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // int data
        X = grid.length;
        Y = grid[0].length;
        int cnt = 0;

        for (int x= 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (grid[x][y] == '1') {
                    dfs(grid, x, y);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * flush recursively
     *
     * @param grid
     * @param x
     * @param y
     */
    void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= X || y >= Y || y < 0 || grid[x][y] != '1') return;
        // current
        grid[x][y] = '0';
        // up
        dfs(grid, x - 1, y);
        // left
        dfs(grid, x, y - 1);
        // right
        dfs(grid, x, y + 1);
        // down
        dfs(grid, x + 1, y);
    }
}
