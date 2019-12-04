/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
    const root = new TrieNode()
    for (const word of words) {
        root.insert(word)
    }
    const res = []
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            backtrack(root, board, i, j, res, '')
        }
    }
    return res
};

const DIRS = [
    [0, -1],
    [-1, 0],
    [1, 0],
    [0, -1],
]

const EMPTY = ''

function backtrack(node, board, x, y, res, acc) {
    if (node.exist) {
        res.push(acc)
        node.exist = false
    }
    if (!callWalk(board, x, y)) return

    const ch = board[x][y]
    if (!node.nexts.has(ch)) return

    board[x][y] = EMPTY
    for (const dir of DIRS) {
        const xx = x + dir[0]
        const yy = y + dir[1]
        backtrack(node.nexts.get(ch), board, xx, yy, res, acc + ch)
    }
    board[x][y] = ch
}


function callWalk(board, x, y) {
    return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] !== EMPTY
}

class TrieNode {
    constructor() {
        this.exist = false
        this.nexts = new Map()
    }

    insert(word) {
        let curr = this
        for (const ch of word) {
            // 疑惑的地方
            if (!curr.nexts.has(ch)) curr.nexts.set(ch, new TrieNode())
            curr = curr.nexts.get(ch)
        }
        curr.exist = true
    }
}
