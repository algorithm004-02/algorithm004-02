//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
// 
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[][] positions = null;
    private int[] rows = null;
    private int[] hills = null;
    private int[] dails = null;

    public List<List<String>> solveNQueens(int n) {
        positions = new char[n][n];
        rows = new int[n];
        hills = new int[2 * n];
        dails = new int[2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions[i][j] = '.';
            }
            rows[i] = 0;
            hills[i] = 0;
            hills[i + n] = 0;
            dails[i] = 0;
            dails[i + n] = 0;
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, n, result);
        return result;
    }

    private boolean isValid(int row, int col, int n) {
        return (rows[col] + hills[row + col] + dails[row - col + n]) == 0;
    }

    private void dfs(int row, int n, List<List<String>> result) {
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                positions[row][col] = 'Q';
                rows[col] = 1;
                hills[row + col] = 1;
                dails[row - col + n] = 1;
                if (row + 1 == n) result.add(construct(positions));
                else dfs(row + 1, n, result);
                positions[row][col] = '.';
                rows[col] = 0;
                hills[row + col] = 0;
                dails[row - col + n] = 0;
            }
        }
    }

    private List<String> construct(char[][] positions) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            String rowStr = new String(positions[i]);
            ans.add(rowStr);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
