import java.util.Deque;
import java.util.LinkedList;

class Solution {

    //==================================== 方法一 =====================================
    /**
     * 处理为树(for嵌套) + DFS + 沉岛模式(标记访问过) 沉岛模式：将每次走过的1都标识为走过了，下次不会重复执行。其实，改为其他的值只要不是1都可以，或者使用其他的数据结构（set等）标识。
     */

    private int rows = 0;
    private int cols = 0;

    // DFS:二维数组，不是树。需要用两重for嵌套来遍历。具体处理每一个1，可以使用DFS来实现。
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {

        // 每次调用dfs()的时候，直接调用。判断是否能执行都在这儿。位置是否超出范围||不为'1'。
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        // 使用沉岛模式，将BFS涉及到的岛屿1都改为0，意味着此位置已经被访问过，则两重for循环中，不会再去重复进行逻辑操作
        grid[i][j] = '0';

        // 四个方向都dfs执行一次
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    //==================================== 方法二 =====================================
    /**
     * 处理为树(for嵌套) + BFS + 沉岛模式(标记访问过) 沉岛模式：将每次走过的1都标识为走过了，下次不会重复执行。其实，改为其他的值只要不是1都可以，或者使用其他的数据结构（set等）标识。
     */

    // BFS:二维数组，不是树。需要用两重for嵌套来遍历。具体处理每一个1，可以使用BFS来实现。
    private int rows = 0;
    private int cols = 0;

    // for循环嵌套来构造BFS执行前的操作
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    // 经典的bfs操作
    private void bfs(char[][] grid, int i, int j) {

        // 每次调用dfs()的时候，直接调用。判断是否能执行都在这儿。位置是否超出范围||不为'1'。
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        // 使用沉岛模式，将BFS涉及到的岛屿1都改为0，意味着此位置已经被访问过，则两重for循环中，不会再去重复进行逻辑操作
        Deque<Loc> deque = new LinkedList<>();

        grid[i][j] = '0';
        deque.add(new Loc(i, j));

        while (!deque.isEmpty()) {
            int len = deque.size(); // len 当前层大小
            for (int k = 0; k < len; k++) {
                Loc loc = deque.poll();

                // 相邻位置进行判断addQueue
                addQueue(grid, loc.i - 1, loc.j, deque);
                addQueue(grid, loc.i + 1, loc.j, deque);
                addQueue(grid, loc.i, loc.j - 1, deque);
                addQueue(grid, loc.i, loc.j + 1, deque);
            }
        }
    }

    private void addQueue(char[][] grid, int i, int j, Deque<Loc> deque) {
        // 判断错误
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }

        // 每次都要沉岛为0，或者其他的数字标识一下即可。
        grid[i][j] = '0';
        deque.add(new Loc(i, j));
    }

    // 辅助class
    public static class Loc {
        int i;
        int j;

        Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
