package implement_trie_prefix_tree

import "testing"

func TestTrie(t *testing.T) {
	trie := Constructor()

	trie.Insert("apple")
	if !trie.Search("apple") {
		t.Fatal("apple have inserted, but not found")
	}

	trie.Search("app")
	if trie.Search("app") {
		t.Fatal("app hasn't inserted, but found")
	}

	if !trie.StartsWith("app") {
		t.Fatal("apple is in ,but app is not start with")
	}

	trie.Insert("app")
	if !trie.Search("app") {
		t.Fatal("app has inserted, but not found")
	}
}
