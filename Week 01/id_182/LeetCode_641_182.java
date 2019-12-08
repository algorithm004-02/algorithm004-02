
/* 
* 题号: 641
* 题目: 设计循环双端队列
* 地址: https://leetcode-cn.com/problems/design-circular-deque/
*/

class MyCircularDeque {
    
    int[] myCircularDeque ;
    int head;    
    int tail;    
    int size;    
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myCircularDeque = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(tail==head && size == capacity) return  false;
        else {
            head = (head - 1 + capacity) % capacity;
            myCircularDeque[head] = value;
            size++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(tail==head && size == capacity) return  false;
        else {
            myCircularDeque[tail] = value;
            tail = (tail + 1 + capacity) % capacity;
            size++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if( tail == head && size == 0) return false;
        else {
            head = (head + 1) % capacity;
            size--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if( tail == head && size == 0) return false;
        else {
            tail = (tail - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if((tail == head) && size==0) return -1;
        else {
            return myCircularDeque[head];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if((tail == head) && size==0) return -1;
        else {
            return myCircularDeque[(tail - 1 + capacity) % capacity];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
