/**
 * 641. ���ѭ��˫�˶���
 MyCircularDeque(k)�����캯��,˫�˶��еĴ�СΪk��
 insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true��
 insertLast()����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true��
 deleteFront()����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true��
 deleteLast()����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true��
 getFront()����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
 getRear()�����˫�˶��е����һ��Ԫ�ء�?���˫�˶���Ϊ�գ����� -1��
 isEmpty()�����˫�˶����Ƿ�Ϊ�ա�
 isFull()�����˫�˶����Ƿ����ˡ�
 *
 * https://leetcode-cn.com/problems/design-circular-deque/ �е�
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


const circularDeque = new MyCircularDeque(3); //  ������СΪ3
circularDeque.insertLast(1);			        //  true
circularDeque.insertLast(2);			        // true
circularDeque.insertFront(3);			        // true
circularDeque.insertFront(4);			        // �Ѿ����ˣ�false
circularDeque.getRear();  				        // 2
circularDeque.isFull();				            // true
circularDeque.deleteLast();			            // true
circularDeque.insertFront(4);			        // true
circularDeque.getFront();				        // 4
console.log( circularDeque )
