package solution;

public class CircularDequeTest {
    public static void main(String[] args) {
        int capacity = 10;
        MyCircularDeque obj = new MyCircularDeque(capacity);
        boolean frontSuccess = obj.insertFront(1);
        boolean lastSuccess = obj.insertLast(10);
        boolean isDeletedFront = obj.deleteFront();
        boolean isDeletedLast = obj.deleteLast();
        int front = obj.getFront();
        int rear = obj.getRear();
        boolean isEmpty = obj.isEmpty();
        boolean isFull = obj.isFull();

        System.out.println( "frontSuccess:" + frontSuccess);
        System.out.println( "lastSuccess:" + lastSuccess);
        System.out.println( "isDeletedFront:" + isDeletedFront);
        System.out.println( "isDeletedLast:" + isDeletedLast);
        System.out.println( "front:" + front);
        System.out.println( "rear:" + rear);
        System.out.println( "isEmpty:" + isEmpty);
        System.out.println( "isFull:" + isFull);
    }
}
