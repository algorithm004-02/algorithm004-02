package Array;

import Array._ArrayList;

public class ArrayList<T> implements _ArrayList<T> {

    private Object[] data;
    //数组长度
    private int n;
    //元素个数
    private int count;

    public ArrayList(int capacity) {
        if (capacity > 0) {
            this.data = new Object[capacity];
            this.n = capacity;
        } else if (capacity == 0){
            this.data = new Object[0];
            this.n = 0;
        } else {
           throw new IllegalArgumentException("illegal");
        }
    }
    public ArrayList(T[] array){
        if (array == null) {
            throw new NullPointerException();
        }
        this.data = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            this.data[i] = array[i];
        }
        this.n = array.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }
    //下标获取元素
    @Override
    public T get(int index) {
        if (index >= 0 && index < this.n) {
            return (T)this.data[index];
        }
        return null;
    }

    //下标设置元素
    @Override
    public T set(int index, T content) {
        if (index > 0 && index < this.n && content != null) {
            T old = (T)this.data[index];
            this.data[index] = content;
            return old;
        }
        return null;
    }
    //下标加元素
    @Override
    public boolean add(int index, T content) {
        if (data == null) {
            return false;
        }
        if (index < 0) {
            index = 0;
        }
        if (index > this.n) {
            index = this.n;
        }
        //如果数组满
        if (this.n == this.data.length) {
            //temp copy
            Object[]  temp = this.data;
            //new Container
            this.data = new Object[temp.length*2];
            //trans data
            for (int i = 0; i < index; ++i) {
                this.data[i] = temp[i];
            }
        }
        //数据后移，index-last
        for (int j = this.data.length-1; j >= index ; --j) {
            this.data[j+1] = this.data[j];
        }
        //插入
        this.data[index] = content;
        this.n++;
        return true;
    }

    //依据index删除元素
    @Override
    public T remove(int index) {
        if (this.n !=0 && index >= 0 && index < this.n){
            T oldElement = (T) this.data[index];
            for (int i = index + 1; i < this.n ; i++) {
                this.data[i] = this.data[i+1];
            }
            //设置尾巴
            this.data[this.n - 1] = null;
            this.n --;
            return oldElement;
        }
        return null;
    }
    @Override
    public boolean remove(T content) {
        return false;
    }

    @Override
    public boolean removeAll(T content) {
        boolean result = false;
        if (this.n !=0 && content != null){
            int i = 0;
            while (i < this.n){
                if (content.equals(this.data[i])){
                    this.remove(i);
                    result = true;
                }
                i++;
            }
        }
        return result;
    }

    @Override
    public boolean add(T content) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T content) {
        return false;
    }

    @Override
    public int indexOf(T content) {
        if (content != null) {
            for (int i = 0; i < this.n; i++) {
                if (this.data[i].equals(content))
                    return i;
            }
        }
        return -1;
    }
}
