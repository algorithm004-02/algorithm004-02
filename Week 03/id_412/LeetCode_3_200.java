package Week03.Chapter09;

public class LeetCode_3_200 {
    // https://leetcode-cn.com/problems/number-of-islands/
    // DFS
    // BFS
    // 并查集

    // flood fill
    // [-1,0]  向上移一位  x控制行数
    // [ 0,1]  向右移一位  y控制列数
    // 上下左右
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};


    private char[][] g;

    private int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        // 行循环
        for (int i = 0; i < g.length; i++) {
            // 列循环
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') {
//                    System.out.printf("Outer continue:i--%d;j--%d;g[i][j]--%s%n", i, j, g[i][j]);
                    continue;
                }
                System.out.printf("Outer :i--%d;j--%d;g[i][j]--%s%n", i, j, g[i][j]);
                islands += sink(i, j);
            }
        }
        return islands;
    }

    private int sink(int i, int j) {
        if (g[i][j] == '0') {
            return 0;
        }
        g[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
//            System.out.printf("Inner loop--k:%d%n", k);
            // 换方向  上下左右
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                if (g[x][y] == '0') {
//                    System.out.printf("Inner continue--k:%d%n", k);
                    // 单方向上元素为0 则 换方向
                    continue;
                }
                sink(x, y);
            }
        }
        System.out.printf("Sink:i--%d;j--%d%n", i, j);
        return 1;
    }

    //  1 1 1 1 0
    //  1 1 0 1 0
    //  1 1 0 0 0
    //  0 0 0 1 0
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '1', '0',}};
        LeetCode_3_200 test = new LeetCode_3_200();
        System.out.println(test.numIslands(grid));
    }
}
