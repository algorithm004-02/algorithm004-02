type MyCircularDeque struct {
    size int
    length int
    data []int
    head int
    tail int
   
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
    return MyCircularDeque{
        size: k,
        length: 0,
        data: make([]int, k),
        head:0,
        tail:-1,
        
    }
    
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
    if this.IsFull() {
        return false
    }
    
    if this.IsEmpty() {
        this.tail = 0
        this.head = 0
    } else {
        
        if this.head == 0 {
            this.head = this.size -1
        } else {
            this.head = this.head -1 
        }
        
    }
    
    
   
    this.data[this.head] = value
    this.length ++ 
    
    return true
    
    
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
    
    if this.IsFull() {
        return false
    }
    
    
    this.tail = (this.tail + 1) % this.size
    
    this.data[this.tail] = value
    
    this.length ++
    
    return true
    
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
    if this.IsEmpty() {
        return false
    }
    
    this.head = (this.head + 1) % this.size
    this.length--
    
    return true
    
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
    
    if this.IsEmpty() {
      
        return false
    }
    
    this.tail = (this.tail -1) % this.size
    
    if this.tail < 0 {
        this.tail = this.tail + this.size
    }
    
    this.length--
    
    return true
    
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
    
    if this.IsEmpty() {
        return -1
    }
    
    
    return this.data[this.head]
    
    
    
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
     if this.IsEmpty()  {
        return -1
    }
    
    
    return this.data[this.tail]
    
    
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
    if this.length == 0 {
        return true
    }
    
    return false
    
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
    
    if this.length  == this.size   {
        return true
    }
    
    return false
    
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