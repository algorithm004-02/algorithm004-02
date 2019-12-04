import java.util.Deque;
import java.util.LinkedList;
class Homework1 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a"); 
        deque.addLast("b"); 
        deque.addLast("c"); 
        System.out.println(deque);
        String str = deque.peekFirst(); 
        System.out.println(str); 
        System.out.println(deque);
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst()); 
        }
        System.out.println(deque);
    }
}