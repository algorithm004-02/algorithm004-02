import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		deque.addLast("one");
		deque.addLast("two");
		deque.addLast("three");
		deque.addLast("four");
		System.out.println(deque);

		String pollElement = deque.pollFirst();
		System.out.println(pollElement);
		System.out.println(deque);

		String peekedElement = deque.peekFirst();
		System.out.println(peekedElement);
		System.out.println(deque);

		while (deque.size() > 0) {
			System.out.println(deque.pollFirst());
		}
	}
}
