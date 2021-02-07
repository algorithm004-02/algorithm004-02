class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if (heights.empty())
            return 0;
        if (heights.size() == 1)
            return heights[0];
        int res = heights[0];
        int i = 1;
        while (i < heights.size()) {
            if (i < heights.size() - 1 && heights[i + 1] >= heights[i]) {
                ++i;
                continue;
            }
            int prev_height = heights[i];
            for (int j = i; j >= 0 && heights[j] > 0; --j) {
                if (heights[j] < prev_height)
                    prev_height = heights[j];
                if (prev_height * (i - j + 1) > res)
                    res = prev_height * (i - j + 1);
            }
            ++i;
        }
        return res;
    }
};
