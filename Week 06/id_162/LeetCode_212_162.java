import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        return findWordsTrie(board, words);
    }

    private List<String> findWordsTrie(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>(words.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfsSearch(i, j, board, root, res);
            }
        }
        return res;
    }

    private void dfsSearch(int i, int j, char[][] board, TrieNode root, List<String> result) {
        //terminal condition
        char val = board[i][j];
        if (val == '#' || root.links[val - 'a'] == null) return;
        root = root.links[val - 'a'];

        //process
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';

        //drill down
        if (i > 0) dfsSearch(i - 1, j, board, root, result);
        if (i < board.length - 1) dfsSearch(i + 1, j, board, root, result);
        if (j > 0) dfsSearch(i, j - 1, board, root, result);
        if (j < board[0].length - 1) dfsSearch(i, j + 1, board, root, result);

        //reverse status
        board[i][j] = val;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode subRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char subChar = word.charAt(i);
                if (subRoot.links[subChar - 'a'] == null) {
                    subRoot.links[subChar - 'a'] = new TrieNode();
                }
                subRoot = subRoot.links[subChar - 'a'];
            }
            subRoot.word = word;
        }
        return root;
    }

    public static class TrieNode {
        TrieNode[] links;
        String word;

        TrieNode() {
            links = new TrieNode[26];
        }
    }
}

