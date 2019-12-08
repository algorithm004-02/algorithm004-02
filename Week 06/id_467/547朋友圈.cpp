class Solution {
public:
    vector<int> p;
    int n;
    int findCircleNum(vector<vector<int>>& M) {
        n = M.size();
        init();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    _union(i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (p[i] == i) {
                ++res;
            }
        }
        return res;
    }

    int find(int target) {
        while (p[target] != target) {
            p[target] = p[p[target]];
            target = p[target];
        }
        return target;
    }
    
    void init() {
        p.resize(n + 1);
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
    }

    void _union(int i, int j) {
        int pa = find(i);
        int pb = find(j);
        if (pa != pb) {
            p[pa] = pb;
        }
    }
};