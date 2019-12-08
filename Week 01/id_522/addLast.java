
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        //peekFirst获取栈首元素后，元素不会出栈
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            //removeFirst获取栈首元素后，元素将会出栈
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}

