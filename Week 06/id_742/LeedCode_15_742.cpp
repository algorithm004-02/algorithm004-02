#define cz(x, p) (((x) & (1 << (p))) >> (p)) == 0

class Solution {
public:
    int *row  = new int[9]();
    int *column  = new int[9]();
    int *square  = new int[9]();

    int dfs(vector<vector<char> >& board, int i, int j)
    {
        if(i == 8 && j == 9) return 1;
        if(i < 8 && j == 9) return dfs(board, i + 1, 0);
        if(board[i][j] != '.') return dfs(board, i, j + 1);
        int idx = 3 * (int)(i / 3) + (int)(j / 3);
        for(int k = 0; k < 9; k++)
            if(cz(row[i], k) && cz(column[j], k) && cz(square[idx], k))
            {
                board[i][j] = k + '1';
                int tmp = 1 << k;
                row[i] |= tmp;
                column[j] |= tmp;
                square[idx] |= tmp;
                int flag = dfs(board, i, j + 1);
                if(flag) return flag;
                row[i] &= ~tmp;
                column[j] &= ~tmp;
                square[idx] &= ~tmp;
                board[i][j] = '.';
            }
        return 0;
    }

    void solveSudoku(vector<vector<char> >& board) {
        int tmp, idx;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.')
                {
                    tmp = 1 << (board[i][j] - '1');
                    row[i] |= tmp;
                    column[j] |= tmp;
                    idx = 3 * (int)(i / 3) + (int)(j / 3);
                    square[idx] |= tmp;
                }
        dfs(board, 0, 0);
    }
};
