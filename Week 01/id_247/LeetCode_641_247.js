/**
 * 641. 设计循环双端队列
 MyCircularDeque(k)：构造函数,双端队列的大小为k。
 insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 getRear()：获得双端队列的最后一个元素。?如果双端队列为空，返回 -1。
 isEmpty()：检查双端队列是否为空。
 isFull()：检查双端队列是否满了。
 *
 * https://leetcode-cn.com/problems/design-circular-deque/ 中等
 *
 */

class MyCircularDeque{

    constructor( k ) {

        this.queue = new Array(k)
        this.front = 0
        this.rear = 0
        this.size = k
    }

    insertFront( value ) {

        if ( this.isFull() )
            return false
        else {
            this.front--
            this.queue[this.front] = value
            return true
        }
    }

    insertLast( value ) {

        if ( this.isFull() )
            return false
        else {
            this.queue[this.rear] = value
            this.rear++
            return true
        }
    }


    deleteFront() {

        if ( this.isEmpty() )
            return false
        else {
            this.front++
            return true
        }
    }

    deleteLast() {

        if ( this.isEmpty() )
            return false
        else {
            this.rear--
            return true
        }
    }

    getFront() {
        return this.isEmpty() ? -1 : this.queue[this.front]
    }

    getRear() {
        return this.isEmpty() ? -1 : this.queue[this.rear - 1]
    }

    isFull() {
        return (this.rear - this.front) == this.size
    }

    isEmpty() {
        return (this.front == this.rear)
    }

}


const circularDeque = new MyCircularDeque(3); //  容量大小为3
circularDeque.insertLast(1);			        //  true
circularDeque.insertLast(2);			        // true
circularDeque.insertFront(3);			        // true
circularDeque.insertFront(4);			        // 已经满了，false
circularDeque.getRear();  				        // 2
circularDeque.isFull();				            // true
circularDeque.deleteLast();			            // true
circularDeque.insertFront(4);			        // true
circularDeque.getFront();				        // 4
console.log( circularDeque )
