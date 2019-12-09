package Array;

public interface _LinkedList<T> {
    boolean isEmpty();
    int length();

    T get(int index);
    T set(int index, T data);

    /*索引添加节点，直接添加节点*/
    boolean add(int index, T data);
    boolean add(T data);

    /*索引移除节点*/
    T remove(int index);
    boolean removeAll(T data);
    void clear();

    /*是否包含data节点*/
    boolean contains(T data);


}
