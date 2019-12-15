package leetcode

/*
 * @lc app=leetcode.cn id=212 lang=golang
 *
 * [212] 单词搜索 II
 */

// @lc code=start
func findWords(board [][]byte, words []string) []string {
	var res []string
	trie := buildTrieNode(words)
	for i := range board {
		for j := range board[i] {
			trieDfs(board, i, j, trie, &res)
		}
	}
	return res
}

func trieDfs(board [][]byte, i, j int, p *TrieNode, res *[]string) {
	c := board[i][j]
	if c == '#' || p.Next[c-'a'] == nil {
		return
	}
	p = p.Next[c-'a']
	if p.Word != nil {
		*res = append(*res, *p.Word)
		p.Word = nil
	}
	board[i][j] = '#'
	if i > 0 {
		trieDfs(board, i-1, j, p, res)
	}
	if j > 0 {
		trieDfs(board, i, j-1, p, res)
	}
	if i < len(board)-1 {
		trieDfs(board, i+1, j, p, res)
	}
	if j < len(board[0])-1 {
		trieDfs(board, i, j+1, p, res)
	}
	board[i][j] = c
}

type TrieNode struct {
	Word *string
	Next []*TrieNode
}

func newNode() *TrieNode {
	next := make([]*TrieNode, 26)
	for i := range next {
		next[i] = nil
	}
	return &TrieNode{Next: next}
}

func buildTrieNode(words []string) *TrieNode {
	root := newNode()
	for i, word := range words {
		p := root
		for _, c := range word {
			i := c - 'a'
			if p.Next[i] == nil {
				p.Next[i] = newNode()
			}
			p = p.Next[i]
		}
		p.Word = &words[i]
	}
	return root
}

// 时间复杂度
// 1. 遍历数组并生成trie N*k
// 2. m * m * k
// N*k + m*m * k

// @lc code=end
