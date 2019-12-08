class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int sum = 0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int idx = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (idx >= g.size()) break;
            if (s[i] >= g[idx]) {
                ++sum;
                ++idx;
            }
        }
        return sum;
    }
};