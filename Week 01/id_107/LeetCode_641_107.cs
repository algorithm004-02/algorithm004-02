public class MyCircularDeque
{
    private int[] _queue;   // 使用数组存储队列元素
    private int _size;      // 队列大小
    private int _front;     // 头指针
    private int _rear;     // 尾指针
    private int _capacity;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k)
    {
        _queue = new int[k];
        _capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public bool InsertFront(int value)
    {
        if (_front == _rear && _size == _capacity) return false;

        _front = (_front + _capacity - 1) % _capacity;
        _queue[_front] = value;
        _size++;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public bool InsertLast(int value)
    {
        if (_front == _rear && _size == _capacity) return false;

        _queue[_rear] = value;
        _rear = (_rear + 1 + _capacity) % _capacity;
        _size++;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public bool DeleteFront()
    {
        if (_front == _rear && _size == 0) return false;

        _front = (_front + 1) % _capacity;
        _size--;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public bool DeleteLast()
    {
        if (_front == _rear && _size == 0) return false;

        _rear = (_rear - 1 + _capacity) % _capacity;
        _size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int GetFront()
    {
        if (_front == _rear && _size == 0) return -1;

        return _queue[_front];
    }

    /** Get the last item from the deque. */
    public int GetRear()
    {
        if (_front == _rear && _size == 0) return -1;

        int index = (_rear - 1 + _capacity) % _capacity;

        return _queue[index];
    }

    /** Checks whether the circular deque is empty or not. */
    public bool IsEmpty()
    {
        return _size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public bool IsFull()
    {
        return _size == _capacity;
    }
}
