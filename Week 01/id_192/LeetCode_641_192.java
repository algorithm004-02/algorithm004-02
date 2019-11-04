class MyCircularDeque {
    int[] arr ;
    int front;
    int rear;
    int size;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.arr = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){//满队
            return false;
        } else {
            front = (front + capacity -1) % capacity;
            arr[front] = value;
            size ++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){//满队
            return false;
        } else {
            arr[rear] = value;
            rear = (rear + 1 + capacity) % capacity;
            size ++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }else {
            front = (front + 1) % capacity;
            size --;
            return  true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }else {
            rear = (rear - 1 + capacity) % capacity;
            size --;
            return  true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return  -1;
        }else {
            return arr[front];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return  -1;
        }else {
            return arr[(rear - 1 + capacity) % capacity];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (rear == front) && size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear==front && size == capacity;
    }
}//基于数组的双端队列 LinkedList是双向链表实现双端队列的最好实践--未进行源码分析
