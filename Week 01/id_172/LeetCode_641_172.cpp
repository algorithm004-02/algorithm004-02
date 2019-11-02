/*
* @Author: yangyazhen
* @Date:   2019-10-20 15:14:03
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 15:14:06
*/
class MyCircularDeque {
public:
    int * deque;
    int front, end, size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        front = end = 0;
        deque = new int[k + 1];
        size = k + 1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + size) % size;
        deque[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull()) return false;
    deque[end] = value;
    end = (end + 1) % size;
    return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1 + size) % size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty()) return false;
        end = (end - 1 + size) % size;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty()) return -1;
        return deque[(end - 1 + size) % size];
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return front == end;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (front - 1 + size) % size == end;   
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
// 循环数组实现
// 申请的空间为k+1，方便判断队列是否占满