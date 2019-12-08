/**
 * 51. N皇后
 n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 给定一个整数 n，返回所有不同的?n?皇后问题的解决方案。
 每一种解法包含一个明确的?n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 *
 * https://leetcode-cn.com/problems/n-queens/
 */

const solveNQueens = ( n ) => {

    const res = [];
    const board = []

    const backtrack = (n, r) => {

        if (r === n) {
            res.push(board.map(i => '.'.repeat(i) + 'Q' + '.'.repeat(n - i - 1)));
            return;
        }

        for (let i = 0; i < n; i++) {

            if (!board.some((bc, br) => bc === i || bc === i + r - br || bc === i - r + br)) {

                board.push(i);
                backtrack(n, r + 1);
                board.pop();
            }
        }
    }

    backtrack(n, 0);
    return res;
}

var solveNQueens2 = function(n) {
    if (n < 1) return [];
    const r = [];
    const cols = new Set();
    const pie = new Set();
    const na = new Set();

    const dfs = (n, row=0, curState=[]) => {
        if (row >= n) {
            r.push(curState);
            return;
        }

        for (let col = 0; col < n; col++) {
            if (cols.has(col) || pie.has(row - col) || na.has(row + col)) continue;
            cols.add(col);
            pie.add(row - col);
            na.add(row + col);

            dfs(n, row + 1, curState.concat([col]));

            cols.delete(col);
            pie.delete(row - col);
            na.delete(row + col);
        }
    }

    const result = [];
    const gen = n => {
        for (let i = 0; i < r.length; i++) {
            result.push(r[i].map(_r => '.'.repeat(_r) + 'Q' + '.'.repeat(n - _r - 1)));
        }
    }

    dfs(n);
    gen(n);

    return result;
};

console.log( solveNQueens2(5) )