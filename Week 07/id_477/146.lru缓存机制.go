package leetcode

/*
 * @lc app=leetcode.cn id=146 lang=golang
 *
 * [146] LRU缓存机制
 */

// @lc code=start
type LRUCache struct {
	Cap  int
	Map  map[int]*Node
	Head *Node
	Last *Node
}

type Node struct {
	Val  int
	Key  int
	Pre  *Node
	Next *Node
}

func Constructor(capacity int) LRUCache {
	cache := LRUCache{
		Cap:  capacity,
		Map:  make(map[int]*Node, capacity),
		Head: &Node{},
		Last: &Node{},
	}
	cache.Head.Next = cache.Last
	cache.Last.Pre = cache.Head
	return cache
}

func (this *LRUCache) Get(key int) int {
	node, ok := this.Map[key]
	if !ok {
		return -1
	}
	this.remove(node)
	this.setHeader(node)
	return node.Val
}

func (this *LRUCache) Put(key int, value int) {
	node, ok := this.Map[key]
	if ok {
		this.remove(node)
	} else {
		if len(this.Map) == this.Cap {
			delete(this.Map, this.Last.Pre.Key)
			this.remove(this.Last.Pre)
		}
		node = &Node{Val: value, Key: key}
		this.Map[node.Key] = node
	}
	node.Val = value
	this.setHeader(node)
}

func (this *LRUCache) setHeader(node *Node) {
	this.Head.Next.Pre = node
	node.Next = this.Head.Next
	this.Head.Next = node
	node.Pre = this.Head
}

func (this *LRUCache) remove(node *Node) {
	node.Pre.Next = node.Next
	node.Next.Pre = node.Pre
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end
