// 1. words --> board 时间复杂度 O(n * m * n * 4 ^ k) 
//     n: 单词的字母数
//     m: * n 格子的数量
//     4: 单元格的四个方向
//     k: 单词的平均长度
// 2. Trie字典树   1. 创建字典树  2. 遍历board 每个节点进行四个方向的深度遍历 查看是否在trie树中 
//     时间复杂度O(m * n * 4 ^ k * k) ？？？待讨论

/**
 * 字典树 + DFS 题解 非优化版
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    // 方向向量
    const dir = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    const res = new Set();

    // 构建字典树
    const wTrie = new Trie();
    words.forEach(word => wTrie.insert(word));
    
    // 遍历二维网格 board
    for(let r = 0; r < board.length; r ++) {
        for (let c = 0; c < board[r].length; c ++) {
            dfs(r, c)
        }
    }
    
    return Array.from(res);

    function dfs(i, j, prefix = '') {
        // 判断有误超出网格
        if (!board[i] || !board[i][j]) return;

        // 判断一个单元格是否被一个单词重复使用
        if (board[i][j] === '@') return;
        
        // 构建单词前缀
        prefix += board[i][j];
        
        // 判断前缀是否为单词 是否存在
        if (!wTrie.startsWith(prefix)) return;
        if (wTrie.search(prefix)) res.add(prefix);
        
        // 四个方向进行深度遍历
        let tmp = board[i][j];
        board[i][j] = '@';
        dir.forEach(d => {
            let r = i + d[0];
            let c = j + d[1];
            dfs(r, c, prefix);
        });
        board[i][j] = tmp;
    }

    function Trie() {
        this.root = {};
        const root = this.root;
        return {root, insert, search, startsWith};

        function insert(word) {
            let cur = root;
            for (let i = 0; i < word.length; i ++) {
                let w = word.charAt(i);
                cur = cur[w] = cur[w] || {}
            }

            cur.isWord = true;
        }

        function search(word) {
            let cur = root;
            for(let i = 0; i < word.length; i ++) {
                let w = word.charAt(i);
                cur = cur[w];
                if (!cur) return false;
            }

            return !!cur.isWord;
        }

        function startsWith(prefix) {
            let cur = root;

            for(let i = 0; i < prefix.length; i ++) {
                let w = prefix.charAt(i);
                cur = cur[w];
                if (!cur) return false;
            }

            return true;
        }
    } 
}
