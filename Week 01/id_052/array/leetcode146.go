package LeetCode

import "container/list"

// LRUCache contains a hash map and a doubly linked list
type LRUCache struct {
	cap int                   // capacity
	l   *list.List            // doubly linked list
	m   map[int]*list.Element // hash table for checking if list node exists
}

// Pair is the value of a list node
type Pair struct {
	key   int
	value int
}

// Constructor initializes a new LRUCache
func Constructor(capacity int) LRUCache {
	return LRUCache{
		cap: capacity,
		l:   new(list.List),
		m:   make(map[int]*list.Element, capacity),
	}
}

// Get a list node from the hash map
func (this *LRUCache) Get(key int) int {
	// check if list node exists
	if node, ok := this.m[key]; ok {
		val := node.Value.(*list.Element).Value.(Pair).value
		// move node to front
		this.l.MoveToFront(node)
		return val
	}
	return -1
}

// Put key and value in the LRUCache
func (this *LRUCache) Put(key int, value int) {
	// check if list node exists
	if node, ok := this.m[key]; ok {
		// move node to front
		this.l.MoveToFront(node)
		// update the value of a list node
		node.Value.(*list.Element).Value = Pair{key, value}
	} else {
		// delete the last list node if the list is full
		if this.l.Len() == this.cap {
			// get the key that we want to delete
			idx := this.l.Back().Value.(*list.Element).Value.(Pair).key
			// delete the node pointer in the hash map by key
			delete(this.m, idx)
			// remove the last list node
			this.l.Remove(this.l.Back())
		}
		// initialize a list node
		node := &list.Element{
			Value: Pair{key, value},
		}
		// push the new list node into the list
		ptr := this.l.PushFront(node)
		// save the node pointer in the hash map
		this.m[key] = ptr
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
