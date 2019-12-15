package word_search_ii

import "fmt"

func findWords(board [][]byte, words []string) []string {
	if len(board) == 0 || len(board[0]) == 0 || len(words) == 0 {
		return []string{}
	}

	trie, resMap, res := Constructor(), map[string]bool{}, []string{}
	//构建字典树
	for _, word := range words {
		trie.Insert(word)
	}

	row, colum := len(board), len(board[0])
	visited := make([][]bool, row)
	for i := 0; i < row; i++ {
		visited[i] = make([]bool, colum)
	}

	for i := 0; i < row; i++ {
		for j := 0; j < colum; j++ {
			if trie.StartsWith(fmt.Sprintf("%c", board[i][j])) {
				dfs(board, visited, "", i, j, trie, resMap)
			}
		}
	}

	for str, _ := range resMap {
		res = append(res, str)
	}

	return res
}

func dfs(board [][]byte, visited [][]bool, str string, i, j int, trie Trie, resMap map[string]bool) {
	if i < 0 || i > len(board)-1 || j < 0 || j > len(board[0])-1 {
		return
	}

	if visited[i][j] {
		return
	}

	str = fmt.Sprintf("%s%c", str, board[i][j])
	if !trie.StartsWith(str) {
		return
	}

	if trie.Search(str) {
		if _, ok := resMap[str]; !ok {
			resMap[str] = true
		}
	}

	visited[i][j] = true
	dfs(board, visited, str, i-1, j, trie, resMap)
	dfs(board, visited, str, i+1, j, trie, resMap)
	dfs(board, visited, str, i, j-1, trie, resMap)
	dfs(board, visited, str, i, j+1, trie, resMap)

	visited[i][j] = false
}
