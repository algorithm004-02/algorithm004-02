package Queue;

public interface _Queue<T> {
    boolean isEmpty();
    int size();

    boolean add(T data);

    T peek();//返回队列头元素

    T poll();//出队

    void clear();//清空队列

}
