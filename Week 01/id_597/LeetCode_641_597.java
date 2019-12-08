/**
 * 设计循环双端列表
 * Created by yangwenwei on 2019/10/19.
 */
public class MyCircularDeque {
    private int size;
    private int k;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.pre = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        Node node = new Node(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        Node node = new Node(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return head.pre.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return tail.next.val;
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
        return size == k;
    }

    private class Node {
        Node pre;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
