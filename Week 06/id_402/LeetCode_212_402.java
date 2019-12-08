class Solution {
    Set<String> set = new HashSet<>();
    char[][] board;
    
    class Trie {//create trie 
        char c;
        boolean isTail = false;
        Trie[] sub = new Trie[26];
        Trie() {}
        Trie(char c) {this.c = c;}
        void insert(String s) {
            Trie trie = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (trie.sub[c - 'a'] == null) {
                    Trie temp = new Trie(c);
                    trie.sub[c - 'a'] = temp;
                    trie = temp;
                } else
                    trie = trie.sub[c - 'a'];                
            }
            trie.isTail = true;
        }        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        Trie root = new Trie();
        for (String s : words) 
            root.insert(s);
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                marked[i][j] = true;
                dfs(new StringBuilder(), root.sub[board[i][j] - 'a'], marked, i, j);
                marked[i][j] = false;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String s : set) {
            ans.add(s);
        }
        return ans;
    }
    
    private void dfs(StringBuilder sb, Trie trie, boolean[][] marked, int i, int j) {
        char c = board[i][j];
        if (trie == null) return;
        sb.append(c);
        if (trie.isTail) {
            set.add(sb.toString());
        }        
        if (i - 1 >= 0 && !marked[i - 1][j]) {
            marked[i - 1][j] = true;
            dfs(sb, trie.sub[board[i - 1][j] - 'a'], marked, i - 1, j);
            marked[i - 1][j] = false;
        }
        if (i + 1 < board.length && !marked[i + 1][j]) {
            marked[i + 1][j] = true;
            dfs(sb, trie.sub[board[i + 1][j] - 'a'], marked, i + 1, j);
            marked[i + 1][j] = false;
        }
        if (j - 1 >= 0 && !marked[i][j - 1]) {
            marked[i][j - 1] = true;
            dfs(sb, trie.sub[board[i][j - 1] - 'a'], marked, i, j - 1);
            marked[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && !marked[i][j + 1]) {
            marked[i][j + 1] = true;
            dfs(sb, trie.sub[board[i][j + 1] - 'a'], marked, i, j + 1);
            marked[i][j + 1] = false;
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}