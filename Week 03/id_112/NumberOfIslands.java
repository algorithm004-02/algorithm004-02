package datastruct.dfsAndbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 *  并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

    示例 1:
     输入:
     11110
     11010
     11000
     00000
     输出: 1


     示例 2:
     输入:
     11000
     11000
     00100
     00011
     输出: 3
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grids = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grids));
    }

    /**
     * 思路一：深度优先遍历DFS
     * 目标是找到矩阵中 “岛屿的数量” ，上下左右相连的 1 都被认为是连续岛屿。
     * dfs方法： 设目前指针指向一个岛屿中的某一点 (i, j)，寻找包括此点的岛屿边界。
     * 从 (i, j) 向此点的上下左右 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 做深度搜索。
     * <p>
     * 终止条件：
     * (i, j) 越过矩阵边界;
     * grid[i][j] == 0，代表此分支已越过岛屿边界。
     * 搜索岛屿的同时，执行 grid[i][j] = '0'，即将岛屿所有节点删除，以免之后重复搜索相同岛屿。
     * <p>
     * 主循环：
     * 遍历整个矩阵，当遇到 grid[i][j] == '1' 时，从此点开始做深度优先搜索 dfs，岛屿数 count + 1 且在深度优先搜索中删除此岛屿。
     * 最终返回岛屿数 count 即可。
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }

    /**
     * 思路二：广度优先遍历 BFS
     * 主循环和思路一类似，不同点是在于搜索某岛屿边界的方法不同。
     * <p>
     * bfs 方法：
     * 借用一个队列 queue，判断队列首部节点 (i, j) 是否未越界且为 1：
     * 若是则置零（删除岛屿节点），并将此节点上下左右节点 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 加入队列；
     * 若不是则跳过此节点；
     * 循环 pop 队列首节点，直到整个队列为空，此时已经遍历完此岛屿。
     */
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i - 1, j});
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i, j - 1});
            }
        }
    }
}