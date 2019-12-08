import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_212_047 {

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (String word :
                words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j, "", result, trie);
            }
        }
        return new ArrayList<>(result);
    }

        private void dfs(char[][] board, boolean[][] visited, int i, int j, String path, Set<String> result, Trie trie) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            path += board[i][j];
            if (!trie.startWith(path)) {
                return;
            }
            if (trie.search(path)) {
                result.add(path);
            }

            visited[i][j] = true;
            dfs(board, visited, i - 1, j, path, result, trie);
            dfs(board, visited, i + 1, j, path, result, trie);
            dfs(board, visited, i, j - 1, path, result, trie);
            dfs(board, visited, i, j + 1, path, result, trie);
            visited[i][j] = false;
        }
}
