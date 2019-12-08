package src.main.java.com.fans.algorithm00402.week3.homework;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */
class LeetCode_200_232 {

    /**
     * 1. DFS
     *  - 采用沉岛策略
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[row].length; col ++) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid) {

        // process
        grid[row][col] = '0';
        // drill down
        if (grid.length > row + 1 && grid[row + 1][col] == '1') dfs(row + 1, col, grid);
        if (grid[row].length > col + 1 && grid[row][col + 1] == '1') dfs(row, col + 1, grid);
        if (row - 1 >= 0 && grid[row - 1][col] == '1')  dfs(row - 1, col, grid);
        if (col - 1 >= 0 && grid[row][col - 1] == '1') dfs(row, col - 1, grid);
    }

    /**
     * 2. BFS
     *  - 采用沉岛策略
     */
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        for (int row = 0; row < grid.length; row ++) {
//            for (int col = 0; col < grid[row].length; col ++) {
//                if (grid[row][col] == '1') {
//                    bfs(row, col, grid);
//                    count ++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void bfs(int row, int col, char[][] grid) {
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(row, col));
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            grid[node.row][node.col] = '0';
//            if (node.row - 1 >= 0 && grid[node.row - 1][node.col] == '1') {
//                queue.add(new Node(node.row - 1, node.col));
//                grid[node.row - 1][node.col] = '0';
//            }
//            if (node.col - 1 >= 0 && grid[node.row][node.col - 1] == '1') {
//                queue.add(new Node(node.row, node.col - 1));
//                grid[node.row][node.col - 1] = '0';
//            }
//            if (node.row + 1 < grid.length && grid[node.row + 1][node.col] == '1') {
//                queue.add(new Node(node.row + 1, node.col));
//                grid[node.row + 1][node.col] = '0';
//            }
//            if (node.col + 1 < grid[node.row].length && grid[node.row][node.col + 1] == '1') {
//                queue.add(new Node(node.row, node.col + 1));
//                grid[node.row][node.col + 1] = '0';
//            }
//        }
//    }
//
//    private class Node {
//        int row;
//        int col;
//        public Node(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }

    public static void main(String[] args) {
        LeetCode_200_232 code = new LeetCode_200_232();
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(code.numIslands(chars));
    }
}
