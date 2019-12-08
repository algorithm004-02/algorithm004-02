package word_search_ii

import "testing"

func TestFindWords(t *testing.T) {
	board := [][]byte{
		{'o', 'a', 'a', 'n'},
		{'e', 't', 'a', 'e'},
		{'i', 'h', 'k', 'r'},
		{'i', 'f', 'l', 'v'},
	}

	words := []string{
		"oath",
		"pea",
		"eat",
		"rain",
	}

	t.Log(findWords(board, words))
}
