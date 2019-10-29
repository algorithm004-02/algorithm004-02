/*
 * @lc app=leetcode id=51 lang=javascript
 * ### 任一两个皇后棋子都不能处在8x8的棋盘同一行、同一列、同一斜线，有多少种摆法？
 * > 回溯算法的基本思想：从一条路往前走，能进则进，不能进则退回来，换一条路再试。
 * > 适用于解空间很大的问题，需要将所有的可能穷举出来，然后找出最优路线，得出整个整个问题的解。
 */
// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
// ------------------------- 解法 1 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
var solveNQueens = function(n) { 
    const res = [];
    backtrack(res, n);
    return res;
};

function backtrack(res, n, board = [], r = 0) {
    if (r === n) {
        res.push(board.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c - 1))); // 记录信息
        return;
    }
    for (let c = 0; c < n; c++) {
        if (!board.some((bc, br) => bc === c || bc === c + r - br || bc === c - r + br)) { // 任一满足，回调执行
            board.push(c);
            backtrack(res, n, board, r + 1);
            board.pop();
        }
    }
}
// @lc code=end