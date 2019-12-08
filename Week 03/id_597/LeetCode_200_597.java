import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 岛屿数量
 * [["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]]
 * <p>
 * Created by yangwenwei on 2019/10/30.
 */
public class LeetCode_200_597 {
    public static void main(String[] args) {
        char[][] gr = new char[4][5];
        for (int i = 0; i < gr.length; i++)
            switch (i) {
                case 0:
                    gr[i] = "11110".toCharArray();
                    break;
                case 1:
                    gr[i] = "11010".toCharArray();
                    break;
                case 2:
                    gr[i] = "11000".toCharArray();
                    break;
                case 3:
                    gr[i] = "00000".toCharArray();
                    break;
            }
        System.out.println(new Solution().numIslands1(gr));
    }

    static class Solution {
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        char[][] g;
        //广度优先的时候运算超时,debug后发现bfs没有设置已经访问过标记导致做了大量重复工作,因此加上visited字段
        int[][] visited;

        //floodfill + DFS
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int res = 0;
            g = grid;
            for (int i = 0; i < g.length; i++)
                for (int j = 0; j < g[i].length; j++)
                    if (g[i][j] == '1') res += sink(i, j);
            return res;
        }

        //DFS
        private int sink(int i, int j) {
            //terminator
            if (g[i][j] == '0') return 0;

            //process
            g[i][j] = '0';
            //drill down
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < g.length && y >= 0 && y < g[i].length)
                    if (g[x][y] == '1') sink(x, y);
            }
            return 1;
        }


        //floodfill + BFS
        public int numIslands1(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int res = 0;
            g = grid;
            visited = new int[grid.length][grid[0].length];
            for (int i = 0; i < g.length; i++)
                for (int j = 0; j < g[i].length; j++)
                    if (g[i][j] == '1') {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        visited[i][j] = 1;
                        res += sink1(list);
                    }
            return res;
        }

        //BFS
        private int sink1(List<Integer> list) {
            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(list);
            while (!queue.isEmpty()) {
                int count = queue.size();
                while (count-- > 0) {
                    List<Integer> ls = queue.poll();
                    int i = ls.get(0), j = ls.get(1);
                    g[i][j] = '0';
                    for (int k = 0; k < dx.length; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x >= 0 && x < g.length && y >= 0 && y < g[i].length && visited[x][y] == 0) {
                            if (g[x][y] == '1') {
                                List<Integer> ll = new ArrayList<>();
                                ll.add(x);
                                ll.add(y);
                                queue.add(ll);
                            }
                            visited[x][y] = 1;
                        }
                    }
                }
            }
            return 1;
        }


        //国际站最优解
        public int numIslands2(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int res = 0;
            g = grid;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++)
                    if (g[i][j] == '1') {
                        //直接深度优先将该点附近的1全冲0, 下一次再遇到一个1说明是一个新岛
                        DFSMarking(i, j);
                        ++res;
                    }
            }
            return res;
        }

        private void DFSMarking(int i, int j) {
            if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != '1') return;
            g[i][j] = '0';
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                DFSMarking(x, y);
            }
        }
    }
}
