import java.util.Deque;
import java.util.LinkedList;

/**
 * Comparison of Stack and Deque methods
 * Stack Method	Equivalent Deque Method
 * push(e)    	addFirst(e)
 * pop()	    removeFirst()
 * peek()	    peekFirst()
 */
class Solution {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        // 把元素压入 Deque 头部中，没有返回值，出错以异常形式处理。
        // deque.push("a");
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        // 检索 Deque 头部的元素而不删除它
        // deque.peek();
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            // 弹出 Deque 头部的元素
            // deque.pop()
            System.out.println(deque.removeFirst());
        }
        System.out.print(deque);
    }
} 