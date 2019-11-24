/*
 * @lc app=leetcode id=212 lang=golang
 *
 * [212] Word Search II
 * 
 */

// @lc code=start
func findWords(board [][]byte, words []string) []string {
    []string {
        var results []string

        m:= len(board)
        if m == 0 {
            return results
        }

        n:= len(board[0])
        if n==0 {
            return results
        }

        trie := buildTrie(words)

    }
}
// @lc code=end

