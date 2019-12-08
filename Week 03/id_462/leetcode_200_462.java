/**
 * 岛屿数量
 */
class Solution {
    /**
     * 考察一个元素的上下左右节点需要用到的辅助数组
     */
    int[] dx = {-1 ,1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[][] g;

    public int numIslands(char[][] grid) {
        int isLand = 0;
        g = grid;
        for (int i = 0; i < g.length;i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') {
                    continue;
                }
                sink(i,j);
                isLand++;
            }
        }
        return isLand;
    }
    //如果是1，则代表是岛屿，只要是联通的全部置为0
    private void sink(int i, int j) {
        if (g[i][j] == '0') {
            return;
        }
        //炸平
        g[i][j] = '0';
        //递归炸平，其实就是深度优先遍历
        for (int l = 0;l < dx.length; l++) {
            int nextI = i + dx[l];
            int nextJ = j + dy[l];
            if (nextI >= 0 && nextI < g.length
                    && nextJ >= 0 && nextJ < g[i].length) {
                if (g[nextI][nextJ] == '0') {
                    continue;
                }
                sink(nextI,nextJ);
            }
        }
    }
}