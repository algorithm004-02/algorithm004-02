package study_datastructure.week_01_homework_04.analyze_and_implement_queue;

/**
 * 自己动手实现一个动态数组
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @param <E>
 */
public class Array<E> {

    private E [] data;
    private int size;

    //有参构造器
    public Array(int capacity){
        data= (E[]) new Object[capacity];
        size=0;
    }
    //无参构造器
    public Array(){
        this(10);
    }
    //获取数组中元素个数
    public int getSize(){
        return size;
    }
    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    //判断数组是否为null
    public boolean isEmpty(){
        return 0 == size;
    }
    //在数组头部添加元素
    public void addFirst(E e){
        add(0,e);
    }
    //在数组尾部添加元素
    public void addLast(E e){
        add(size,e);
    }
    //在数组索引 index 处添加元素
    public void add(int index,E e){
        //判断索引是否有效
        if(index < 0 || index > size )
            throw new IllegalArgumentException("add failed , Require index >=0 and index <=size");

        /*//先判断数组是否已经满了
        if(size == data.length)
            throw new IllegalArgumentException("add failed , Array is full");*/

        //如果数组已经满了 我们就扩容
        if (size == data.length)
            resize(size * 2);


        for (int i = size -1 ; i >= index; i--)
            data[i+1] = data[i];

        data[index]=e;
        size++;
    }
    //查询索引处的元素
    public E get(int index){
        //判断索引是否有效
        if(index < 0 || index >= size )
            throw new IllegalArgumentException("get failed , Require index >=0 and index <size");

        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //修改索引处的元素
    public void set(int index,E e){
        //判断索引是否有效
        if(index < 0 || index >= size )
            throw new IllegalArgumentException("set failed , Require index >=0 and index <size");

        data[index]=e;
    }
    //查询数组中是否包含某元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    //查询数组元素 e 所在的索引,找不到则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    //从数组中删除index 位置的元素，并返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed , Require index >=0 and index <size");

        E ret=data[index];
        for (int i = index+1; i < size; i++)
            data[i-1]=data[i];

        size--;
        data[size]=null;
        //如果数组元素 缩减到只有容量的1/4 ，那就缩容 (为了防止复杂度震荡)
        if(size == data.length/4 && data.length /2 != 0)
            resize(data.length/2);

        return ret;
    }
    //删除数组的第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除数组最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    public void removeElement(E e){
        int index=find(e);
        if (-1 != index)
             remove(index);
    }
    //改变数组的容量大小
    public void resize(int newCapacity){
        E [] newData= (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data=newData;
//        newData=null;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d \n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size -1 )
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }

}
