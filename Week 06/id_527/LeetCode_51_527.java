import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        dfs(0, n, pie, na, new HashSet<>(), result, new ArrayList<>());
        return result;
    }

    private void dfs(int level, int n, Set<Integer> pie, Set<Integer> na, Set<Integer> col, List<List<String>> results,
            List<String> tempList) {
        if (level > n - 1) {
            if (tempList.size() == n) {
                List<String> result = new ArrayList<>(tempList);
                results.add(result);
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            if (pie.contains(level + j) || na.contains(j - level) || col.contains(j)) {
                continue;
            }
            pie.add(level + j);
            na.add(j - level);
            col.add(j);

            String temp = getStr(n, j);
            tempList.add(temp);

            dfs(level + 1, n, pie, na, col, results, tempList);

            pie.remove(level + j);
            na.remove(j - level);
            col.remove(j);
            tempList.remove(temp);
        }
    }

    private String getStr(int n, int j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
// @lc code=end
