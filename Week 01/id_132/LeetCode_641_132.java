public class MyCircularDeque  {
    // 循环双端队列实现：
    // head指针指向数组的头，每次插入则数组倒着增长，
    // tail指向数组的头，每次插入正着增长。
    private int[] data;
    private int head;
    private int tail;
    private int capacity;
    private int count;

    public MyCircularDeque(int k) {
        data = new int[k];
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        data[head = ((head - 1 + capacity) % capacity)] = value;
        ++count;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        data[tail] = value;
        tail = (tail + 1) % capacity;
        ++count;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        --count;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail - 1 + capacity) % capacity;
        --count;

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : data[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : data[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
