class MyCircularDeque {
    private var array: [Int]
    private let capacity: Int
    /** Initialize your data structure here. Set the size of the deque to be k. */
    init(_ k: Int) {
        array = []
        capacity = k
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    func insertFront(_ value: Int) -> Bool {
        if isFull() { return false }
        array.insert(value, at: 0)
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    func insertLast(_ value: Int) -> Bool {
        if isFull() { return false }
        array.append(value)
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    func deleteFront() -> Bool {
        if isEmpty() { return false }
        array.removeFirst()
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    func deleteLast() -> Bool {
        if isEmpty() { return false }
        array.removeLast()
        return true
    }

    /** Get the front item from the deque. */
    func getFront() -> Int {
        return array.first ?? -1
    }

    /** Get the last item from the deque. */
    func getRear() -> Int {
        return array.last ?? -1
    }

    /** Checks whether the circular deque is empty or not. */
    func isEmpty() -> Bool {
        return array.isEmpty
    }

    /** Checks whether the circular deque is full or not. */
    func isFull() -> Bool {
        return array.count == capacity
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * let obj = MyCircularDeque(k)
 * let ret_1: Bool = obj.insertFront(value)
 * let ret_2: Bool = obj.insertLast(value)
 * let ret_3: Bool = obj.deleteFront()
 * let ret_4: Bool = obj.deleteLast()
 * let ret_5: Int = obj.getFront()
 * let ret_6: Int = obj.getRear()
 * let ret_7: Bool = obj.isEmpty()
 * let ret_8: Bool = obj.isFull()
 */
