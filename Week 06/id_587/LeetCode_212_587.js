/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
  let result = [];
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  function buildTrie() {
    const root = {};
    for (let word of words) {
      let node = root;

      word.split('').forEach(c => {
        node[c] = node[c] || {};
        node = node[c];
      });

      node.end = word;
    }
    return root;
  }

  function search(node, i, j) {
    if (node.end != null) {
      result.push(node.end);
      node.end = null;
    }

    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return;
    }

    if (node[board[i][j]] == null) {
      return;
    }

    const tmp = board[i][j];
    board[i][j] = '@';

    for (let k = 0; k < 4; k++) {
      search(node[tmp], i + dx[k], j + dy[k]);
    }

    board[i][j] = tmp;
  }

  const root = buildTrie();

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      search(root, i, j);
    }
  }

  return result;
};
