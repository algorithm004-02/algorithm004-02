package Stack;

import org.omg.CORBA.Object;

import java.util.EmptyStackException;

public class ArrayStack<T> implements _Stack<T>  {

    //container
    private T[] arr;
    //length
    private int size;
    //top
    private int index = -1;
    private int init = 100;

    public ArrayStack(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }
    public ArrayStack() {
        this.arr = (T[]) new Object[this.init];
    }



    public int getSize() {
        return this.size;
    }

    public void getLargeStack(int capacity) {
        if (capacity < size)
            return;

        T[] old = this.arr;
        arr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            arr[i] = old[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return this.index == -1;
    }

    @Override
    public void push(T data) {
        if (arr.length == size) {
            getLargeStack(size*2 );
        }
        arr[index++] = data;
        size++;
    }


    @Override
    public T peek() {
        if (isEmpty())
            throw new NullPointerException();
        return arr[index];
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NullPointerException();
        size--;
        return arr[index--];
    }
}
