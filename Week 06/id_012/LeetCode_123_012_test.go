package main

import "testing"

type Node struct {
	IsWord bool
	Next   map[rune]*Node
}

type Trie struct {
	Root *Node
	Size int
}

func (trie *Trie) add(s string) bool {
	cur := trie.Root
	for _, char := range s {
		if cur.Next == nil {
			cur.Next = make(map[rune]*Node)
		}
		if _, ok := cur.Next[char]; !ok {
			cur.Next[char] = &Node{}
		}
		cur = cur.Next[char]
	}
	if cur.IsWord == false {
		cur.IsWord = true
		trie.Size++
	}
	return true
}

func (trie *Trie) addReCursion(s string) bool {
	trie.help(s, 0, len(s)-1, trie.Root)
	return true
}

func (trie *Trie) help(s string, index int, l int, cur *Node) *Node {
	if index == l {
		if cur.IsWord == false {
			cur.IsWord = true
			trie.Size++
		}
		return cur
	}

	if cur.Next == nil {
		cur.Next = make(map[rune]*Node)
	}
	key := rune(s[index])
	if _, ok := cur.Next[key]; !ok {
		cur.Next[key] = &Node{}
	}
	index++
	return trie.help(s, index, l, cur.Next[key])

}

func (trie *Trie) search(s string) bool {
	return true
}

func TestMain(t *testing.T) {
	myTrie := &Trie{
		Root: &Node{},
		Size: 0,
	}
	s := "abc"
	myTrie.addReCursion(s)
	myTrie.addReCursion("abcd")
	myTrie.addReCursion("ebc")

	t.Log(myTrie.Size)
}
