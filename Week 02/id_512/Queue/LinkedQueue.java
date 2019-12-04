package Queue;

import Node.Node;

public class LinkedQueue<T> implements _Queue<T> {
    //head out ,tail input
    public Node<T> head;
    public Node<T> tail;

    public int size;

    public LinkedQueue() {

        this.tail = this.head = null;

    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T data) {
        Node<T> node = new Node<T>(data,null);
        //空队列插入,插入头部
        if (this.head == null) {
            this.head = node;
        } else {
            //尾部插入
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
        return true;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : this.head.data;
    }

    @Override
    public T poll() {
        if (this.isEmpty())
            return null;
        T old = this.head.data;
        this.head = this.head.next;

        //如果最后poll完，整个链表空。
        if (this.head == null) {
            this.tail = null;
        }
        size--;
        return old;
    }

    @Override
    public void clear() {
        this.head = this.tail = null;
        this.size = 0;
    }
}
