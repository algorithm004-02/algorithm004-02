public class LeetCode_52_677 {
    public static void main(String[] args) {
        ISolution s1 = new Solution1();
        int ans = s1.totalNQueens(8);
        System.out.println(ans);
    }
}

interface ISolution {
    int totalNQueens(int n);
}

class Solution1 implements ISolution {
    private int size;
    private int count;

    private void solve(int row, int ld, int rd) {
        // terminator
        if (row == size) {
            count++;
            return;
        }

        int position = size & (~(row | ld | rd));
        while (position != 0) {
            int p = position & (-position);
            position -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    @Override
    public int totalNQueens(int n) {
        count = 0;
        // init 1 bit for n
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }
}
