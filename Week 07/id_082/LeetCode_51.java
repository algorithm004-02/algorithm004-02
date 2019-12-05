import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * @version v1.0
 */
public class LeetCode_51 {
	int[] rows;
	int[] hills;
	int[] dales;
	int n;
	// queens positions
	int[] queens;
	List<List<String>> output = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		rows = new int[n];
		hills = new int[2*n - 1];
		dales = new int[2*n - 1];
		queens = new int[n];

		backtrack(0);
		return output;
	}

	private void backtrack(int row) {
		for (int col=0; col<n; col++) {
			if (isNotUnderAttack(row, col)) {
				placeQueen(row, col);
				if (row+1 == n) {
					addSolution();
				} else {
					backtrack(row+1);
				}
				removeQueen(row, col);
			}
		}
	}

	private void removeQueen(int row, int col) {
		queens[row] = 0;
		rows[col] = 0;
		hills[row-col+2*n] = 0;
		dales[row+col] = 0;
	}

	private void addSolution() {
		List<String> solution = new ArrayList<>();
		for (int i=0; i<n; i++) {
			int col = queens[i];
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<col; j++) sb.append(".");
			sb.append("Q");
			for (int j=0; j<n-col-1; j++) sb.append(".");
			solution.add(sb.toString());
		}
		output.add(solution);
	}

	private void placeQueen(int row, int col) {
		queens[row] = col;
		rows[col] = 1;
		hills[row-col+2*n] = 1;
		dales[row+col] = 1;
	}

	private boolean isNotUnderAttack(int row, int col) {
		int res = rows[col]+hills[row-col+2*n]+dales[row+col];
		return res == 0 ? true:false;
	}
}
