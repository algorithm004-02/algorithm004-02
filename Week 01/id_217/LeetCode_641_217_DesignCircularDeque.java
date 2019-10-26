public class DesignCircularDeque {
    class MyCircularDeque {

        private int[] elements;
        private int head;
        private int tail;
        private int MAX_SIZE;
        private int count;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            elements = new int[k];
            head = tail = -1;
            MAX_SIZE = k;
            count = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            head = (head - 1 + MAX_SIZE) % MAX_SIZE;
            elements[head] = value;
            count++;
            if (count == 1) {
                tail = head;
            }
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            tail = (tail + 1) % MAX_SIZE;
            elements[tail] = value;
            count++;
            if (count == 1) {
                head = tail;
            }
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = (head + 1) % MAX_SIZE;
            count--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = (tail - 1 + MAX_SIZE) % MAX_SIZE;
            count--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) return -1;
            return elements[head];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) return -1;
            return elements[tail];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return count == MAX_SIZE;
        }

    }

}
