//import java.util.Deque;
import java.util.LinkedList;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/10/20
 */
public class DequeRewrite {





  public static void main(String[] args) {
   /**
    * 改写前代码：
    * LinkedList<String> deque = new LinkedList<String>();

    deque.push("a");
    deque.push("b");
    deque.push("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }
    System.out.println(deque);

    */


    //改写后代码
    LinkedList<String> deque = new LinkedList<String>();

    deque.addLast("a"); //addLast从尾压入元素，
    deque.addLast("b");
    deque.addLast("c");
    System.out.println(deque);

    String str = deque.getFirst();
    deque.removeFirst();

    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.getFirst());
      deque.removeFirst();

    }
    System.out.println(deque);

  }

}
