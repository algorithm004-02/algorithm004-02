package com.algorithm.qinchao.homework.week06;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 17:16
 * @description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_202 {
    public static int numIslands(char[][] grid) {
        int result = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    recursive(dx, dy, grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void recursive(int[] dx, int[] dy, char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length && grid[x][y] != '0') {
                recursive(dx, dy, grid, x, y);
            }
        }
    }

    public static void main(String[] args) {

        char[][] M = new char[][]{{'1', '1', '0'},
                {'1', '1', '1'},
                {'0', '1', '1'}};

        System.out.println(LeetCode_200_202.numIslands(M));
        System.out.println(LeetCode_200_202.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}
