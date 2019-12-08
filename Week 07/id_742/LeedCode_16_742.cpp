class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.empty()) {
            return 0;
        }
        int row = matrix.size(), col = matrix[0].size();
        int res = 0;
        vector<int> height(col, 0);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    continue;
                }                
                ++height[j];
                int minH = height[j];
                for (int k = j; k >= 0; --k) {
                    minH = min(minH, height[k]);
                    res = max(res, minH * (j - k + 1));
                }             
            }
        }
        return res;
    }
};
