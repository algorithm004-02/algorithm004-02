package Stack;

public interface _Stack<T> {

    boolean isEmpty();

    void push(T data);
    //get the top element and not pop it
    T peek();

    T pop();
}
