class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> cache = new HashSet<>(16);
        Set<Character> cache2 = new HashSet<>(16);
        int[][] a = new int[3][3];
        Set<Character>[][] caches = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !cache.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cache2.add(board[j][i])) {
                    return false;
                }

                if (caches[i / 3][j / 3] == null) {
                    caches[i / 3][j / 3] = new HashSet<>(16);
                }
                if (board[i][j] != '.' && !caches[i / 3][j / 3].add(board[i][j])) {
                    return false;
                }
            }
            cache.clear();
            cache2.clear();
        }
        return true;
    }
}