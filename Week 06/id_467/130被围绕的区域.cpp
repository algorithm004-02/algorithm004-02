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

    bool isConnect(int n1, int n2) {
        return find(n1) == find(n2);
    }
};

class Solution {
public:
    int row;
    int col;
    void solve(vector<vector<char>>& board) {
        if (board.size() == 0) return;
        row = board.size();
        col = board[0].size();
        UnionFind uf = UnionFind(row * col + 1);
        int tmpnode = row * col;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        uf._union(getIndex(i, j), tmpnode);
                    } else {
                        if (i > 0 && board[i-1][j] == 'O') {
                            uf._union(getIndex(i, j), getIndex(i-1, j));
                        }
                        if (i < row - 1 && board[i+1][j] == 'O') {
                            uf._union(getIndex(i, j), getIndex(i+1, j));
                        }
                        if (j > 0 && board[i][j-1] == 'O') {
                            uf._union(getIndex(i, j), getIndex(i, j-1));
                        }
                        if (j < col - 1 && board[i][j+1] == 'O') {
                            uf._union(getIndex(i, j), getIndex(i, j+1));
                        }                        
                    }
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (uf.isConnect(getIndex(i, j), tmpnode)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int getIndex(int i, int j) {
        return i * col + j;
    }
};