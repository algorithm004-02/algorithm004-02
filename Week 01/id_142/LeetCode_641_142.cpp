/*
 * @lc app=leetcode.cn id=641 lang=cpp
 *
 * [641] 设计循环双端队列
 *
 * https://leetcode-cn.com/problems/design-circular-deque/description/
 *
 * algorithms
 * Medium (48.10%)
 * Likes:    17
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 5.6K
 * Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n' +
  '[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * 
 * 
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 
 * 
 * 示例：
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);                    // 返回 true
 * circularDeque.insertLast(2);                    // 返回 true
 * circularDeque.insertFront(3);                    // 返回 true
 * circularDeque.insertFront(4);                    // 已经满了，返回 false
 * circularDeque.getRear();                  // 返回 2
 * circularDeque.isFull();                        // 返回 true
 * circularDeque.deleteLast();                    // 返回 true
 * circularDeque.insertFront(4);                    // 返回 true
 * circularDeque.getFront();                // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * 
 * 
 */

// @lc code=start
class MyCircularDeque {
private:
     int move_forward(int idx) {
        return (idx + 1) % max_size;
    }

    int move_backward(int idx) {
        return (idx + max_size - 1) % max_size;
    }

    int* arr;
    int head;
    int tail;
    int size;
    int max_size;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) : head(0), tail(0), size(0), max_size(k) {
        arr = new int[k];
        assert(arr);
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        assert(arr);
        // 已满返回
        if (isFull()) return false;

        // 头部插入，头部指针往前更新
        arr[head] = value;
        head = move_backward(head);

        // 若插入前为空，则尾部指针向后更新
        if (isEmpty()) {
            tail = move_forward(tail);
        }

        // 大小更新
        size++;

        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        assert(arr);
        // 判满
        if (isFull()) return false;

        // 尾部插入，尾指针向后更新
        arr[tail] = value;
        tail = move_forward(tail);
        // 若插入前为空，则头指针向前更新
        if (isEmpty()) {
            head = move_backward(head);
        }

        // 大小更新
        size++;

        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        assert(arr);
        // 判空
        if (isEmpty()) return false;

        // 头指针向后更新
        head = move_forward(head);

        // 若删除前只有一个元素，尾指针向前更新
        if (size == 1) {
            tail = move_backward(tail);
        }

        // 大小更新
        size--;

        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        assert(arr);
        // 判空
        if (isEmpty()) return false;

        // 尾指针向前更新
        tail = move_backward(tail);

        // 若删除前只有一个元素，头指针向后更新
        if (size == 1) {
            head = move_forward(head);
        }

        // 大小更新
        size--;

        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        assert(arr);
        // 判空
        if (isEmpty()) return -1;

        // 返回头指针后一个元素
        return arr[move_forward(head)];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        assert(arr);
        // 判空
        if (isEmpty()) return -1;

        // 返回尾指针元素前一个元素
        return arr[move_backward(tail)];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size == max_size;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
// @lc code=end

