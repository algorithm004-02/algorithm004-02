#include <iostream>
#include <vector>
#include <minwindef.h>

using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.empty()) {
            return 0;
        }
        int row = matrix.size();
        int col = matrix[0].size();
        int sidelen = 0;
        int pre;
        vector<int> dp(col, 0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = dp[j];
                if (!i || !j || matrix[i][j] == '0') {
                    dp[j] = matrix[i][j] - '0';
                } else {
                    dp[j] = min(pre, min(dp[j], dp[j - 1])) + 1;
                }
                sidelen = max(dp[j], sidelen);
                pre = temp;
            }
        }
        return sidelen * sidelen;
    }
};