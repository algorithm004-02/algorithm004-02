import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_047 {
    int n;
    int[] queens;
    int[] rows;
    int[] forwardSlash;
    int[] backSlash;
    List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        this.rows = new int[n];
        this.forwardSlash = new int[2 * n - 1];
        this.backSlash = new int[3 * n];
        backTrack(0);
        return solutions;
    }

    private void backTrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) {
                    addSolution();
                } else {
                    backTrack(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        forwardSlash[row + col] = 0;
        backSlash[row - col + 2 * n] = 0;
    }

    private void addSolution() {
        List<String> aSolution = new ArrayList<>(n);
        for (int row = 0; row < n; row++) {
            StringBuilder solutionSB = new StringBuilder();
            int queenPos = queens[row];
            for (int i = 0; i < queenPos; i++) {
                solutionSB.append(".");
            }
            solutionSB.append("Q");
            for (int i = queenPos + 1; i < n; i++) {
                solutionSB.append(".");
            }
            aSolution.add(solutionSB.toString());
        }
        solutions.add(aSolution);
    }

    private void placeQueen(int row, int col) {
        this.queens[row] = col;
        this.rows[col] = 1;
        this.backSlash[row - col + 2 * n] = 1;
        this.forwardSlash[row + col] = 1;
    }

    private boolean isNotUnderAttack(int row, int col) {
        int sum = rows[col] + backSlash[row - col + 2 * n] + forwardSlash[row + col];
        return sum == 0;
    }
}
