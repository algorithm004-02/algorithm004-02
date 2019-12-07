package Array;

import Node.Node;

/**
 * 循环带头单链表
 *
 * */
public class CircleWithHeadLinkedList<T> implements _LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;

    public CircleWithHeadLinkedList() {
        this.head = new Node<>(null);
        /*初始空表，把头指向自己*/
        this.head.next = head;
        this.tail = head;
    }
    public CircleWithHeadLinkedList(T[] arr){
        this();
        if (arr != null && arr.length > 0) {
            /*初始化，头，尾都准备好。第一个元素*/
            this.head.next = new Node<>(arr[0],head);
            tail = this.head.next;
            int i = 0;
            while (i < arr.length) {
                tail.next = new Node<>(arr[i++]);
                tail.next.next = head;//
                tail = tail.next;

            }
        }
    }
    public CircleWithHeadLinkedList(CircleWithHeadLinkedList<T> arr) {

    }

    @Override
    public boolean isEmpty() {
        //循环头指向头，则为空链表
        return this.head.next == head;
    }

    @Override
    public int length() {
        int length = 0;
        Node<T> node = this.head.next;
        //这里是判断标准变成了 !=null -> != head因为死循环。头指向自己
        while (node != head) {
            node = node.next;
            length++;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index > 0) {
            int i = 0;
            Node<T> current = this.head.next;
            while (current != null && i < index) {
                current = current.next;
                i++;
            }
            if (current != null) {
                return current.data;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (data == null) {
            return null;
        }
        if (index >= 0) {
            int i = 0;
            Node<T> current = this.head.next;
            while ( current != head && i < index) {
                current = current.next;
                i++;
            }
            if (current != head) {
                T old = current.data;
                current.data = data;
                return old;
            }
        }
        return null;
    }
    @Override
    public boolean add(int index, T data) {
        int size = length();
        if (data == null || index < 0 || index >= size )
            return false;

        int i = 0;
        Node<T> current = this.head;
        //find before index
        while (current.next != head && i < index) {
            current = current.next;
            i++;
        }
        //new node 新插入节点，插入前节点current，插入后节点current.next
        Node<T> node = new Node<>(data,current.next);
        current.next = node;
        //update 尾巴指向
        if (current == tail){
            this.tail = node;
        }
        return true;
    }

    @Override
    public boolean add(T data) {
        //直接加在尾巴上
        if (data == null)
            return false;
        Node<T> current = new Node<>(data,this.tail.next);
        this.tail.next = current;
        //update 尾巴指向
        this.tail = current;
        return false;
    }


    @Override
    public T remove(int index) {
        int size = length();
        if (index < 0 || index > size || isEmpty())
            return null;

        int i = 0;
        //find before index one - > current
        Node<T> current = this.head.next;

        while (current != head && i < index) {
            current = current.next;
            i++;
        }
        if (current != head) {
            T old = current.next.data;
            if (tail == current.next){
                tail = current;
            }
            current.next = current.next.next;
            return old;
        }
        return null;
    }

    @Override
    public boolean removeAll(T data) {
        boolean remove = false;
        if (data == null) {
            return false;
        }
        //front 删除前节点，node，当前节点
        Node<T> front = this.head;
        Node<T> node = front.next;
        while (node != head) {
            if (data.equals(node.data)) {
                //刚好是尾巴节点.node 则被删除
                if (data.equals(tail.data)) {
                    this.tail = front;
                }
                front.next = node.next;
                node = front.next;
                remove = true;
            } else {
                //删除前节点，和删除节点，依次后移
                front = node;
                node = node.next;
            }
        }
        return remove;
    }

    @Override
    public void clear() {
        this.head.next = head;
        this.tail = head;
    }

    @Override
    public boolean contains(T data) {
        if (data != null) {
            return false;
        }
        //遍历前节点
        Node<T> node = this.head.next;

        while (node != head) {
            if (data.equals(node.data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
