class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string>         tmp(n, string(n, '.'));
        vector<bool>           col(n, true);
        vector<bool>           pie(2*n-1, true);
        vector<bool>           na(2*n-1, true);
        solve(res, n, 0, col, tmp, pie, na);
        return res;
    }
    
    void solve(vector<vector<string>>& res, int n, int row, vector<bool>& col, vector<string>& tmp, vector<bool>& pie, vector<bool>& na) {
        if (row == n) {
            res.push_back(tmp);
            return;
        }
        for (int i = 0; i < n; ++i){
            int ll = row + i;
            int rr = row - i + n - 1;
            if (col[i] && pie[ll] && na[rr]) {
                tmp[row][i] = 'Q';
                col[i]      = false;
                pie[ll]     = false;
                na[rr]      = false;
                solve(res, n, row+1, col, tmp, pie, na);
                tmp[row][i] = '.';
                col[i]      = true;
                pie[ll]     = true;
                na[rr]      = true;
            }
        }
    }    
};