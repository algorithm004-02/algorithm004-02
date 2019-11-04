class Solution {
   public:
    // 更新一个未显示过的‘M’，并处理周围方块
    void markAndQueue(const vector<int>& pos, queue<vector<int>>& posQueue,
        vector<vector<char>>& board, vector<vector<bool>>& visited)
    {
        int mineNum = 0;
        int bNum = 0;
        vector<vector<int>> arounds;
        for (int i = pos[0] - 1; i < pos[0] + 2; ++i) {
            if (i < 0 || i >= board.size()) {
                continue;
            }
            for (int j = pos[1] - 1; j < pos[1] + 2; ++j) {
                if (j < 0 || j >= board[0].size()) {
                    continue;
                }
                if (board[i][j] == 'M') {
                    mineNum++;
                } else if (board[i][j] == 'E' && !visited[i][j]) {
                    arounds.push_back(vector<int>{i, j});
                }
            }
        }
        // 如果此方块要显示为数字，则搜索停止
        if (mineNum == 0) {
            board[pos[0]][pos[1]] = 'B';
            for (auto& val : arounds) {
                posQueue.push(val);
            }
        } else {
            board[pos[0]][pos[1]] = '0' + mineNum;
        }
        visited[pos[0]][pos[1]] = true;
    }

    void updateEmptySquare(vector<vector<char>>& board, vector<int>& click)
    {
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        queue<vector<int>> posQueue;
        posQueue.push(click);
        while (!posQueue.empty()) {
            vector<int> pos = posQueue.front();
            posQueue.pop();
            // visit and book it
            if (!visited[pos[0]][pos[1]]) {
                markAndQueue(pos, posQueue, board, visited);
            }
        }
    }

    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        // 0. 无需考虑input异常
        char& clickContent = board[click[0]][click[1]];
        // 1. 检查是否点到地雷
        if (board[click[0]][click[1]] == 'M') {
            clickContent = 'X';
            return board;
        }
        // 2. 更新所有”M“面板，包括计算地雷附近数字
        updateEmptySquare(board, click);
        return board;
    }
};
