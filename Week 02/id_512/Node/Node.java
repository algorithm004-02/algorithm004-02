package Node;

public class Node<T> {

    public T data;  //content

    public Node<T>  next;   //pointer


    public Node(T data){
        this.data = data;
    }
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }


}
