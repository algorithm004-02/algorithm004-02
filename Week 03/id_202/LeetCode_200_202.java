package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/1 18:18
 * @description
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_202 {
    public static int numIslandsByDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int outSize = grid.length;
        int inSize = grid[0].length;
        int result = 0;
        for (int out = 0; out <outSize ; out++) {
            for (int in = 0; in <inSize; in++) {
                if (grid[out][in] == '1') {
                    result++;
                    recursive(outSize, inSize, out, in,grid);
                }
            }
        }
        return result;
    }

    private static void recursive(int outSize, int inSize, int out, int in, char[][] grid) {
        if (in >= inSize || out >= outSize || in < 0 | out < 0 || grid[out][in] == '0') {
            return;
        }
        //沉掉
        grid[out][in] = '0';
        recursive(outSize, inSize, out - 1, in, grid);
        recursive(outSize, inSize, out + 1, in, grid);
        recursive(outSize, inSize, out , in-1, grid);
        recursive(outSize, inSize, out, in+1, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(LeetCode_200_202.numIslandsByDFS(grid));
        System.out.println(LeetCode_200_202.numIslandsByDFS(grid2));
    }
}
