package Queue;


public class ArrayQueue<T> implements _Queue<T> {
    public T[] arr;
    public int size = 0;
    //head out ,tail input
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.size = capacity;
    }
    /*数据搬移，然后再插入。
    * */
    public boolean betterAdd(T data) {
        //tail no space
        if (tail == size) {
            //full
            if (head == 0) {
                return false;
            }
            //move to pre for save space
            for (int i = head; i < tail ; i++) {
                this.arr[i-head] = arr[head];
            }
            tail = tail-head;//tail -= head;
            head = 0;
        }
        this.arr[tail] = data;
        tail++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T data) {
        //full
        if (tail == size)
            return false;
        this.arr[tail] = data;
        tail++;
        return true;
    }

    @Override
    public T peek() {
        return this.arr[head] ;
    }

    @Override
    public T poll() {
        //empty
        if (head == tail)
            return null;
        //head out tail input
        T old = this.arr[head];
        head++;
        return old;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            arr[i] = null;
        }
        this.size = 0;
        this.head = this.tail = 0;
    }
}
