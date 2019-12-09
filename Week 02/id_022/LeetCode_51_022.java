//[51]N皇后
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    private List<List<String>> result;

    private byte[] cols;
    private byte[] slashes;
    private byte[] backslashes;

    public List<List<String>> solveNQueens(int n) {

        result = new LinkedList<>();
        cols = new byte[n];
        slashes = new byte[2 * n];
        backslashes = new byte[2 * n];

        put(new int[n], 0, n);
        return result;
    }

    private void put(int[] queens, int row, int n) {
        if (row == n) {
            result.add(toString(queens));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (unsafe(row, col, n)) {
                continue;
            }

            queens[row] = col;
            cols[col] = 1;

            // 点斜式标记斜线
            slashes[row - col + n] = 1;
            backslashes[row + col] = 1;

            put(queens, row + 1, n);

            //rollback
            cols[col] = 0;
            slashes[row - col + n] = 0;
            backslashes[row + col] = 0;
        }
    }


    private boolean unsafe(int row, int col, int n) {
        return cols[col] == 1
                || slashes[row - col + n] == 1
                || backslashes[row + col] == 1;
    }

    private List<String> toString(int[] queens) {
        List<String> solution = new ArrayList<>(queens.length);
        for (int queen : queens) {
            char[] line = new char[queens.length];
            for (int col = 0; col < queens.length; col++) {
                line[col] = queen == col ? 'Q' : '.';
            }
            solution.add(new String(line));
        }
        return solution;
    }


    public static void main(String[] args) {
        NQueens solution = new NQueens();
        List<List<String>> result = solution.solveNQueens(4);
        System.out.println(result);
        if (!"[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]".equals(result.toString())) {
            throw new AssertionError("case1");
        }
    }


}