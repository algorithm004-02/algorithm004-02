package Array;
/*顺序表接口*/

public interface _ArrayList<T> {
    boolean isEmpty();

    int length();

    T get(int index);

    T set(int index , T data);

    boolean add(int index , T data);

    boolean add(T data);
//  根据index删除元素
    T remove(int index);
//  根据data删除元素
    boolean remove (T data);
//  删除所有
    boolean removeAll(T data);
    void clear();
//  根据data查询是否存在
    boolean contains(T data);

    int indexOf(T data);


}
