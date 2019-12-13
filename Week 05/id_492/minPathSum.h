#include <iostream>
#include <vector>
#include <minwindef.h>

using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        
        vector<int> dp(row, grid[0][0]);
        for (int i = 1; i < row; i++) {
        	dp[i] = dp[i - 1] + grid[i][0];
        }
        for (int j = 1; j < col; j++) {
        	dp[0] += grid[0][j];
        	for (int i = 1; i < row; i++) {
        		dp[i] = min(dp[i - 1], dp[i]) + grid[i][j];
        	}
        }
        return dp[row - 1];
    }
};