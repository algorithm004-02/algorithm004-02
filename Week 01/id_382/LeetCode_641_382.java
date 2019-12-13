
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class LeetCode_641_382 {

    Stack<Integer> stack = null;
    Queue<Integer> queue = null;
    int maxSize;

    /**
     * 构造函数,双端队列的大小为k
     */
    public LeetCode_641_382(int k) {
        stack = new Stack<>();
        queue = new ArrayBlockingQueue(k);
        this.maxSize = k;
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!addRange(value)) {
            return false;
        }
        boolean addSuccess = this.queue.add(value);
        if (addSuccess) {
            return true;
        }
        return false;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        if (!addRange(value)) {
            return false;
        }
        boolean addSuccess = this.stack.add(value);
        if (addSuccess) {
            return true;
        }
        return false;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true
     */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        Integer deleteFrontValue = this.queue.poll();
        if (deleteFrontValue != null) {
            return true;
        }
        return false;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true
     */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        Integer deleteLastValue = this.stack.pop();
        if (deleteLastValue != null) {
            return true;
        }
        return false;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1
     */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        Integer frontValue = this.queue.peek();
        if (frontValue != null) {
            return frontValue;
        }
        return -1;
    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
     */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        Integer lastValue = this.stack.peek();
        if (lastValue != null) {
            return lastValue;
        }
        return 0;
    }

    /**
     * 检查双端队列是否为空。
     */
    public boolean isEmpty() {
        if (this.queue.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 检查双端队列是否满了
     */
    public boolean isFull() {
        if (this.queue.size() == maxSize) {
            return true;
        }
        return false;
    }

    private boolean addRange(Integer value) {
        if (value >= 1 && value <= 1000) {
            return true;
        }
        return false;
    }

}
