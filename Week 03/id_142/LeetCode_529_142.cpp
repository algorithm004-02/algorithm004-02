/*
 * @lc app=leetcode.cn id=529 lang=cpp
 *
 * [529] 扫雷游戏
 *
 * https://leetcode-cn.com/problems/minesweeper/description/
 *
 * algorithms
 * Medium (56.28%)
 * Likes:    39
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 4.1K
 * Testcase Example:  '[["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]]\n' +
  '[3,0]'
 *
 * 让我们一起来玩扫雷游戏！
 * 
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B'
 * 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X'
 * 则表示一个已挖出的地雷。
 * 
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 
 * 
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: 
 * 
 * [['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'M', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E']]
 * 
 * Click : [3,0]
 * 
 * 输出: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * 解释:
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * Click : [1,2]
 * 
 * 输出: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'X', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * 解释:
 * 
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 * 
 */

// @lc code=start
class Solution {
public:
    bool valid_click(char grid) {
        return grid == 'M' || grid == 'E';
    }

    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if (click.size() < 2 || click[0] >= board.size() || 
            click[1] >= board[click[0]].size() ||
            (board[click[0]][click[1]] != 'E' && board[click[0]][click[1]] != 'M')) return board;

        int x = click[0], y = click[1];

        // 如果点击的是M，变更方格为X，游戏结束
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        // 点击
        Click(x, y, board);

        return board;
    }

    void Click(int x, int y, vector<vector<char>>& board) {
        int bomb = 0;
        // 遍历八方向
        // 上
        if (x > 0 && board[x-1][y] == 'M') {
            bomb++;
        }
        // 下
        if (x < board.size() - 1 && board[x+1][y] == 'M') {
            bomb++;
        }
        // 左
        if (y > 0 && board[x][y-1] == 'M') {
            bomb++;
        }
        // 右
        if (y < board[x].size() - 1 && board[x][y+1] == 'M') {
            bomb++;
        }
        // 左上
        if (x > 0 && y > 0 && board[x-1][y-1] == 'M') {
            bomb++;
        }
        // 左下
        if (x < board.size() - 1 && y > 0 && board[x+1][y-1] == 'M') {
            bomb++;
        }
        // 右上
        if (x > 0 && y < board[x].size() - 1 && board[x-1][y+1] == 'M') {
            bomb++;
        }
        // 右下
        if (x < board.size() - 1 && y < board[x].size() - 1 && board[x+1][y+1] == 'M') {
            bomb++;
        }

        if (bomb == 0) {
            board[x][y] = 'B';
        } else {
            board[x][y] = (char)(bomb + 0X30);
            return;
        }

        // 八方向尝试点击
        // 上
        if (x > 0 && valid_click(board[x-1][y])) {
            Click(x-1, y, board);
        }
        // 下
        if (x < board.size() - 1 && valid_click(board[x+1][y])) {
            Click(x+1, y, board);
        }
        // 左
        if (y > 0 && valid_click(board[x][y-1])) {
            Click(x, y-1, board);
        }
        // 右
        if (y < board[x].size() - 1 && valid_click(board[x][y+1])) {
            Click(x, y+1, board);
        }
        // 左上
        if (x > 0 && y > 0 && valid_click(board[x-1][y-1])) {
            Click(x-1, y-1, board);
        }
        // 左下
        if (x < board.size() - 1 && y > 0 && valid_click(board[x+1][y-1])) {
            Click(x+1, y-1, board);
        }
        // 右上
        if (x > 0 && y < board[x].size() - 1 && valid_click(board[x-1][y+1])) {
            Click(x-1, y+1, board);
        }
        // 右下
        if (x < board.size() - 1 && y < board[x].size() - 1 && valid_click(board[x+1][y+1])) {
            Click(x+1, y+1, board);
        }
    }
};
// @lc code=end

