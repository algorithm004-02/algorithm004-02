package Stack;

import Node.Node;

public class LinkedStack<T> implements _Stack<T> {

    public Node<T> top;
    public int size;

    public LinkedStack() {
        this.top = new Node<T>(null);
    }
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    @Override
    public void push(T data) {
        if (data == null)
            throw new NullPointerException();
        if (this.top == null) {
            this.top = new Node<T>(data);
        } else if (this.top.data == null){
            this.top.data = data;
        } else {
            Node<T> node = new Node<T>(data,this.top);
            this.top = node;
        }
        size ++;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NullPointerException();
        return top.data;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NullPointerException();
        T old = top.data;
        top = top.next;
        size--;
        return old;
    }
}
