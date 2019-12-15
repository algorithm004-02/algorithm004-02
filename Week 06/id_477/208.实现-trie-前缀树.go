package leetcode

/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
type Trie struct {
	NodeMap map[rune]*Trie
	isEnd   bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{NodeMap: make(map[rune]*Trie)}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this
	for _, s := range word {
		if _, ok := node.NodeMap[s]; !ok {
			node.NodeMap[s] = &Trie{NodeMap: make(map[rune]*Trie)}
		}
		node = node.NodeMap[s]
	}
	node.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this
	for _, s := range word {
		if tmp, ok := node.NodeMap[s]; ok {
			node = tmp
		} else {
			return false
		}
	}
	return node != nil && node.isEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this
	for _, s := range prefix {
		if tmp, ok := node.NodeMap[s]; ok {
			node = tmp
		} else {
			return false
		}
	}
	return node != nil
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end
