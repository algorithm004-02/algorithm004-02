
public class _641_designcirculardeque {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(4);                    // 已经满了，返回 false
        circularDeque.getRear();                  // 返回 2
        circularDeque.isFull();                        // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.insertFront(4);                    // 返回 true
        circularDeque.getFront();                // 返回 4

        circularDeque = new MyCircularDeque(5);
        circularDeque.insertFront(7);
        circularDeque.insertLast(0);
        circularDeque.getFront();
        circularDeque.insertLast(3);
        circularDeque.getFront();
        circularDeque.insertFront(9);
        circularDeque.getRear();
        circularDeque.getFront();
        circularDeque.getFront();
        circularDeque.deleteLast();
        circularDeque.getRear();
    }
}

class MyCircularDeque {

    int cap = 0;

    int size = 0;

    Node head;

    Node tail;

    class Node {
        int value;
        Node next;
        Node pre;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        cap = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == cap) return false;
        size++;
        Node n = new Node(value);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.pre = n;
            head = n;
        }
        if (tail == null) {
            tail = n;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == cap) return false;
        size++;
        Node n = new Node(value);
        if (head == null) {
            head = n;
        }
        if (tail == null) {
            tail = n;
        }  else {
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) return false;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            Node tmp = head;
            head = head.next;
            head.pre = null;
            tmp.next = null;
            tmp = null;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) return false;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            Node tmp = tail;
            tail = tail.pre;
            tail.next = null;
            tmp.pre = null;
            tmp = null;
        }

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) return -1;
        return head.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) return -1;
        return tail.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == cap ? true : false;
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
