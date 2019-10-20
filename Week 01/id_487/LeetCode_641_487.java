class LeetCode_1_487{


    /***
     * 641题
     *
     * 设计实现双端队列。
     */

    private int[] deque;    //队列
    private int start;      //头指针
    private int end;        //尾指针
    private int size;       //大小
    private int max_size;   //容量

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        deque = new int[k];
        start = -1;
        end = -1;
        size = 0;
        max_size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        start = (start - 1 + max_size) % max_size;
        deque[start] = value;
        size++;
        if (size == 1) {
            end = start;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        end = (end + 1) % max_size;
        deque[end] = value;
        size++;
        if (size == 1) {
            start = end;
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        start = (start + 1) % max_size;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        end = (end - 1 + max_size) % max_size;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return (isEmpty()) ? -1 : deque[start];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return (isEmpty()) ? -1 : deque[end];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == max_size;
    }

}