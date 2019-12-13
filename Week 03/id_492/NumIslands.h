#ifndef _NUMISLANDS_H_
#define _NUMISLANDS_H_

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int rowlen = grid.size();
        if (rowlen <= 0) {
            return 0;
        }
        int collen = grid[0].size();

        int numislands = 0;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if (grid[i][j] == '1') {
                    numislands++;
                    dfs(grid, rowlen, collen, i, j);
                }
            }
        }

        return numislands;
    }

private:
    void dfs(vector<vector<char>>& grid, int rowlen, int collen, int r, int c) {
        grid[r][c] = '0';
        if (r - 1 >= 0 && grid[r - 1][c] == '1')
            dfs(grid, rowlen, collen, r - 1, c);
        if (r + 1 < rowlen && grid[r + 1][c] == '1')
            dfs(grid, rowlen, collen, r + 1, c);
        if (c - 1 >= 0 && grid[r][c - 1] == '1')
            dfs(grid, rowlen, collen, r, c - 1);
        if (c + 1 < collen && grid[r][c + 1] == '1')
            dfs(grid, rowlen, collen, r, c + 1);
    }
};

#endif
