/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    int[] array;
    int count = 0;
    int head = 0;
    int tail = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (count == array.length) {
            return false;
        }
        if (head == 0) {
            head = array.length - 1;
        } else {
            head--;
        }
        array[head] = value;
        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (count == array.length) {
            return false;
        }
        array[tail] = value;
        if (tail == array.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (count == 0) {
            return false;
        }
        if (head == array.length - 1) {
            head = 0;
        } else {
            head++;
        }
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (count == 0) {
            return false;
        }
        if (tail == 0) {
            tail = array.length - 1;
        } else {
            tail--;
        }
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (count == 0) {
            return -1;
        }
        return array[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (count == 0) {
            return -1;
        }
        if (tail == 0) {
            return array[array.length - 1];
        }
        return array[tail - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == array.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
