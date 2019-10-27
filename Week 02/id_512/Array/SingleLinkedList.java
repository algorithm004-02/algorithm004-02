package Array;

import Node.Node;

public class SingleLinkedList<T> implements _LinkedList<T> {
    public Node<T> head;
    //public Node<T> end;

    public SingleLinkedList(Node<T> head){
        this.head = head;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (this.head == null)
            result = true;
        return result;
    }

    @Override
    public int length() {
        int n = 0;
        Node<T> temp = head;
        while (temp !=null){
            n ++;
            temp = temp.next;
        }
        return n;
    }

    @Override
    public T get(int index) {
        if (this.head != null && index > 0){
            int count = 0;
            Node<T> temp = this.head;
            while (temp != null && count < index){
                temp = temp.next;
                count ++;
            }
            if (temp != null) {
                return temp.data;
            }

        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (this.head != null && index > 0 ) {
            int count = 0;
            Node<T> temp = this.head;
            //find target node
            while (temp != null && count < index){
                temp = temp.next;
                count ++;
            }
            if (temp != null){
                T old = temp.data;
                temp.data = data;
                return old;
            }
        }
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        if (data == null){
            return false;
        }
        /*add at begin.*/
        /**
        * Node<T> p = new Node<T>(data,null)
        * p.next = this.head;
        * this.head = p;
        * */
        if (this.head == null || index <= 1) {
            this.head = new Node<T>(data,this.head);
        } else {
             /*add in middle*/
            /**
             * Node<T> tNode = new Node<>(data,null);
             * tNode.next = front.next;//先赋node尾巴到p
             * front.next = tNode;//再赋node头链到front
             */
             /*add at last*/
            /**
             * Node<T> tNode = new Node<>(data,null);
             * tNode.next = null;
             * front.next = tNode;
             */
            int count = 0;
            Node<T> front = this.head;
            //找到插入index前的那个node
            while (front.next != null && count < index-1){
                front = front.next;
                count ++;
            }
            front.next = new Node<>(data,front.next);
        }
        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        T old = null;
        if (this.head != null && index >= 0) {
            /*remove at begin.*/
            /**
             * 让第二个当头
             * head = head.next
             **/
            if (index == 0) {
                old = this.head.data;
                this.head = this.head.next;
            } else {
                /*remove at middle or last.*/
                /**
                 * 找到index前一个node。把删除targetNode = node.Next
                 * node.Next = targetNode.next;即可。
                 * targetNode = null;这步是为了free gc Node
                 **/
                Node<T> front = this.head;
                int count = 0;
                while (this.head.next != null && count < index -1) {
                    front = front.next;
                    count ++;
                }
                //get the index one
                Node<T> result = front.next;
                if (result != null) {
                    old = result.data;
                    //front.next = front.next.next
                    front.next = result.next;
                    //GC? 不写的话 result 永远没有被指向
                    result = null;
                }
            }
        }
        return old;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }
}
