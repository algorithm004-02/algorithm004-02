import java.util.NoSuchElementException;

// https://leetcode-cn.com/problems/design-circular-deque/
// 双向链表实现
class MyCircularDeque {
    // deque的容量
    int size;
    
    //当前的元素数量
    int used = 0;

    // 节点类型
    class ListNode {
        int data;
        ListNode next;
        ListNode prev;
        public ListNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    //我们通过一个在队列为空时，带头带尾的双向链表来实现
    // deque的dummy头
    ListNode first;

    // deque的dummy尾
    ListNode last;

    //队列真正的指示数据头尾的指针
    ListNode head;
    ListNode tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
        first = new ListNode(-1);
        last = new ListNode(-1);
        first.next = last;
        first.prev = last;
        last.next = first;
        last.prev = first;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (used >= size)
            return false;
        used++;
        ListNode element = new ListNode(value);
        element.next = first.next;
        first.next = element;
        element.prev = first;
        element.next.prev = element;
        updateHeadAndTail(first, last);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (used >= size)
            return false;
        used++;
        ListNode element = new ListNode(value);

        element.next = last;
        element.prev = last.prev;
        last.prev.next = element;
        last.prev = element;
        updateHeadAndTail(first, last);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (used <= 0)
            return false;
        used--;
        first.next = head.next;
        head.next.prev = first;
        head.next = null;
        head.prev = null;
        updateHeadAndTail(first, last);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (used <= 0)
            return false;
        used--;

        tail.prev.next = tail.next;
        last.prev = tail.prev;
        tail.prev = null;
        tail.next = null;
        updateHeadAndTail(first, last);
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (used <= 0) return -1;
        int data = head.data;
        return data;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (used == 0) return -1;
        int data = tail.data;
        return data;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return used == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return used == size;
    }
    private void updateHeadAndTail (ListNode dummyHead, ListNode dummyTail) {
        head = dummyHead.next;
        tail = dummyTail.prev;
    }
}