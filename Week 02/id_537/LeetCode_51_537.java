package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class LeetCode_51_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_51_537().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }
            List<List<String>> results = new ArrayList<>();
            search(0, new int[]{}, n, results);
            return results;
        }

        private void search(int i, int[] ints, int n, List<List<String>> results) {
            if (i == n) {
                results.add(printChessboard(ints));
                return;
            }
            a:
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < ints.length; m++) {
                    if (j == ints[m] || j == ints[m] - (m - i) || j == ints[m] + (m - i))
                        continue a;
                }
                int[] nextInts = Arrays.copyOf(ints, ints.length + 1);
                nextInts[nextInts.length - 1] = j;
                search(i + 1, nextInts, n, results);
            }
        }

        private List<String> printChessboard(int[] queens) {
            if (queens == null || queens.length == 0) {
                return null;
            }
            List<String> result = new ArrayList<>();
            for (int queen : queens) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < queens.length; ++j) {
                    line.append(j == queen ? "Q" : ".");
                }
                result.add(line.toString());
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}