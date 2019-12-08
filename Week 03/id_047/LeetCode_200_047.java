import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_200_047 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sinkIsland(i, j, grid);
                }
            }
        }
        return count;
    }
    private void sinkIsland(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int h = point[0];
            int w = point[1];

            if (h - 1 >= 0 && grid[h - 1].length > w && grid[h - 1][w] == '1') {
                grid[h - 1][w] = '0';
                queue.add(new int[]{h - 1, w});
            }
            if (h + 1 < grid.length && grid[h + 1].length > w && grid[h + 1][w] == '1') {
                grid[h + 1][w] = '0';
                queue.add(new int[]{h + 1, w});
            }
            if (w - 1 >= 0 && grid[h][w - 1] == '1') {
                grid[h][w - 1] = '0';
                queue.add(new int[]{h, w - 1});
            }
            if (w + 1 < grid[h].length && grid[h][w + 1] == '1') {
                grid[h][w + 1] = '0';
                queue.add(new int[]{h, w + 1});
            }
        }
    }
}
