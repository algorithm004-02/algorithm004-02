class UnionFind {
public:
    vector<int> p;
    UnionFind (int size) {
        p.resize(size);
        for (int i = 0; i < size; ++i) {
            p[i] = i;
        }
    }

    void _union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 != p2) {
            p[p2] = p1;
        }
    }

    int find(int t) {
        while (p[t] != t) {
            p[t] = p[p[t]];
            t = p[t];
        }
        return t;
    }
};

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0) return 0;
        int n = grid.size(), m = grid[0].size();
        UnionFind uf = UnionFind(n * m);

        static int dx[] = {-1, 1, 0, 0};
        static int dy[] = {0, 0, -1, 1};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k ++) {
                        int new_x = i + dx[k];
                        int new_y = j + dy[k];
                        if (0 <= new_x && new_x < n && 0 <= new_y && 
                            new_y < m && grid[new_x][new_y] == '1') {
                            uf._union(new_x * m + new_y, i * m + j);
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n * m; i ++) {
            if (grid[i/m][i%m] == '1' && uf.p[i] == i) {
                ++res;
            }
        }
        return res;
    }
};
