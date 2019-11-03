package leetcode

/*
 * @lc app=leetcode.cn id=641 lang=golang
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
type MyCircularDeque struct {
	Queue    []int
	Head     int
	Tail     int
	Size     int
	Capacity int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	deque := MyCircularDeque{
		Queue:    make([]int, 0, k),
		Head:     0,
		Tail:     0,
		Size:     0,
		Capacity: k,
	}
	for i := 0; i < k; i++ {
		deque.Queue = append(deque.Queue, 0)
	}
	return deque
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.Size == this.Capacity {
		return false
	}
	this.Head = (this.Head - 1 + this.Capacity) % this.Capacity
	this.Queue[this.Head] = value
	this.Size++
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.Size == this.Capacity {
		return false
	}
	this.Queue[this.Tail] = value
	this.Tail = (this.Tail + 1) % this.Capacity
	this.Size++
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.Size == 0 {
		return false
	}
	this.Head = (this.Head + 1) % this.Capacity
	this.Size--
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.Size == 0 {
		return false
	}
	this.Tail = (this.Tail - 1 + this.Capacity) % this.Capacity
	this.Size--
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.Size == 0 {
		return -1
	}
	return this.Queue[this.Head]
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.Size == 0 {
		return -1
	}
	idx := (this.Tail - 1 + this.Capacity) % this.Capacity
	return this.Queue[idx]
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.Size == 0
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.Size == this.Capacity
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
// @lc code=end
