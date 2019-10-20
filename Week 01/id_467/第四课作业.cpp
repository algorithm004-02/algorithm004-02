1. 641. 设计循环双端队列
class MyCircularDeque {
public:
    stack<int> head;
    stack<int> tail;
    int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (head.size() + tail.size() < size) {
            head.push(value);
            return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (head.size() + tail.size() < size) {
            tail.push(value);
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (head.empty()) {
            while (!tail.empty()) {
                int t = tail.top();
                head.push(t);
                tail.pop();
            }
        }
        if (head.empty()) {
            return false;
        } else {
            head.pop();
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (tail.empty()) {
            while (!head.empty()) {
                int t = head.top();
                tail.push(t);
                head.pop();
            }
        }
        if (tail.empty()) {
            return false;
        } else {
            tail.pop();
            return true;
        }      
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (head.empty()) {
            while (!tail.empty()) {
                int t = tail.top();
                head.push(t);
                tail.pop();
            }
        }
        if (head.empty()) {
            return -1;
        } else {
            return head.top();
        }      
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (tail.empty()) {
            while (!head.empty()) {
                int t = head.top();
                tail.push(t);
                head.pop();
            }
        }
        if (tail.empty()) {
            return -1;
        } else {
            return tail.top();
        }        
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return head.size() == 0 && tail.size() == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return head.size() + tail.size() >= size;
    }
};


2. 42. 接雨水

class Solution {
public:
    int trap(vector<int>& height) {
        int sum = 0;
        stack<int> s;
        for (int i = 0; i < height.size(); ++i) {
            while (!s.empty() && height[i] > height[s.top()]) {
                int cur = s.top();
                s.pop();
                if (s.empty()) break;
                int _min = min(height[s.top()], height[i]);
                sum += ((i - s.top() - 1) * (_min - height[cur]));
            }
            s.push(i);
        }
        return sum;
    }
};
