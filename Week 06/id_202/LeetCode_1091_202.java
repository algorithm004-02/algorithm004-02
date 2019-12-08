package com.algorithm.qinchao.homework.week06;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/23 11:17
 * @description 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * <p>
 * 输出：4
 * <p>
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1091_202 {
    class Element {
        public int row;
        public int col;

        public Element(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            Element element = (Element) o;
            return row == element.row &&
                    col == element.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int shortestPathBinaryMatrixByDoubleDFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        int length = grid.length - 1;
                      // 左      右      下       上      左下角   右上角   右下角  左上角
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        Set<Element> startSet = new HashSet<>();
        startSet.add(new Element(0, 0));
        Set<Element> endSet = new HashSet<>();
        endSet.add(new Element(length, length));
        boolean[][] visited = new boolean[length + 1][length + 1];
        visited[0][0] = true;
        visited[length][length] = true;
        int result = 1;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<Element> tempSet = startSet;
                startSet = endSet;
                endSet = tempSet;
            }
            Set<Element> change = new HashSet<>();
            for (Element element : startSet) {
                int x = element.row;
                int y = element.col;
                for (int i = 0; i < dir.length; i++) {
                    int dx = x + dir[i][0];
                    int dy = y + dir[i][1];
                    if (endSet.contains(new Element(dx, dy))) {
                        return result + 1;
                    }
                    if (dx >= 0 && dx <= length && dy >= 0 && dy <= length && !visited[dx][dy] && grid[dx][dy] != 1) {
                        change.add(new Element(dx, dy));
                        visited[dx][dy] = true;
                    }
                }
            }
            startSet = change;
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_1091_202().shortestPathBinaryMatrixByDoubleDFS(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new LeetCode_1091_202().shortestPathBinaryMatrixByDoubleDFS(new int[][]{{0, 0, 0},
                                                                                        {1, 1, 0},
                                                                                        {1, 1, 0}}));
    }
}
