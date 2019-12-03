package id_432

type Trie struct {
	end  bool
	nextTrie *[26]*Trie
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{nextTrie: &[26]*Trie{}}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	head := this
	for _, c := range word {
		index := c - 'a'
		if nextNode := head.nextTrie[index]; nextNode == nil {
			trie := Constructor()
			nextNode = &trie
			head.nextTrie[index] = nextNode
			head = nextNode
		} else {
			head = nextNode
		}
	}
	head.end = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	head := this
	for _, c := range word {
		index := c - 'a'
		if nextNode := head.nextTrie[index]; nextNode == nil {
			return false
		} else {
			head = nextNode
		}
	}
	return head.end == true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	head := this
	for _, c := range prefix {
		index := c - 'a'
		if nextNode := head.nextTrie[index]; nextNode == nil {
			return false
		} else {
			head = nextNode
		}
	}
	return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */