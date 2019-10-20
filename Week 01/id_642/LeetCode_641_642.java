package week1;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/19 23:25
 *
 * https://leetcode-cn.com/problems/design-circular-deque
 */
public class DesignCircularDeque {

  /**
   * 1、采用数组实现.
   * 2、双指针front(头元素的位置)，last (尾元素下一个位置).
   * 3、头部插入元素，front左移，插入元素.
   * 4、尾部插入元素, 插入到last处，last右移.
   * 5、删除头部元素, front右移.
   * 6、删除尾部元素, last左移.
   * */

  private int front, last, count = 0;

  private int[] data;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public DesignCircularDeque(int k) {
    data = new int[k];
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    front = front == 0 ? data.length - 1 : front - 1;
    data[front] = value;
    count++;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    data[last] = value;
    last = (last + 1) % data.length;
    count++;
    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    front = (front + 1) % data.length;
    count--;
    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    last = last == 0 ? data.length - 1 : last - 1;
    count--;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return data[front];
  }

  /** Get the last item from the deque. */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return last == 0 ? data[data.length - 1] : data[last - 1];
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return count == 0;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return count == data.length;
  }
}
