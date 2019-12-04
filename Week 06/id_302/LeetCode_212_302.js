/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    let res = [];
    const dy=[-1, 1, 0, 0] // vertical movement (up, down)
    const dx=[0,0,-1, 1] // horizontal movement (left, right)

    // create a trie and insert char into it. 
    function buildTrie() {
        const root = {};
        for(let w of words) {
            let node = root;
            w.split('').forEach(c => node = node[c] = node[c] || {});
            node.end = w;
        }
        return root;
    }

    function search(node, i, j) {
        if(node.end != null) {
            res.push(node.end);
            node.end = null; // make sure only print one time for each word. 
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return; 
        // when we move our cur char, we need to 
        // make sure don't crossover the bound of the grid. 
        if(node[board[i][j]] == null) return; // the terminator 
        // when the char can't find in the trie, then that mean this is dead end or we have push the end to our res.

        const c = board[i][j]; // current logic level 
        board[i][j] = '@'; // when it's current char, we mark it so it won't use in drill down level.
        
        for(let k=0; k<4; k++) {
            search(node[c], i+dy[k], j+dx[k]); // drill down 
        }
        board[i][j] = c; // resume the current char for the next iteration.
    }

    const root = buildTrie();
    for(let i=0; i<board.length; i++) {
        // i is vertical iteration
        for(let j=0; j<board[0].length; j++) {
            // j is horizontal iteration
            search(root, i, j);
        }
    }
    return res;
};