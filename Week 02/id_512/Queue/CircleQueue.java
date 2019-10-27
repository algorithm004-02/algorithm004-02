package Queue;

import org.omg.CORBA.Object;

public class CircleQueue<T> implements _Queue<T> {
    public T[] arr;
    public int size;

    public int tail;
    public int head;

    public static final int DEFAULT = 10;

    public CircleQueue() {
        this.arr = (T[]) new Object[DEFAULT];
        head = tail = 0;
    }
    public CircleQueue(int capacity) {
        this.arr = (T[]) new Object[capacity];
        head = tail = 0;
    }

     /*
        环状会有一个unit space 不会被存储内容
        cause： 差1 tail == head（队列空）
        环状满时，（tail+1）% size = head
     */

    public void getLargeQueue(int capacity) {
        if (capacity < size)
            return;

        T[] old = this.arr;
        this.arr = (T[]) new Object[capacity];
        int j = 0;
        //copy the element
        for (int i = this.head;i != this.tail; i =(i+1) % old.length) {
            arr[j++] = old[i];
        }
        this.head = 0;
        this.tail = j;

    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T data) {
        //满环队列。
        if (this.head == (this.tail + 1) % this.arr.length ) {
            getLargeQueue(arr.length*2);
        }
        //添加data
        arr[this.tail] = data;
        this.tail = (this.tail+1) % arr.length;
        size++;
        return true;
    }

    @Override
    public T peek() {
        return arr[head];
    }

    @Override
    public T poll() {
        T temp = this.arr[this.head];
        this.head = (this.head + 1) % this.arr.length;
        size--;
        return temp;
    }

    @Override
    public void clear() {
        for (int i = this.head ; i != this.tail; i=(i+1)%arr.length) {
            arr[i] = null;
        }
        this.head = this.tail = 0;
        size = 0;
    }
}
