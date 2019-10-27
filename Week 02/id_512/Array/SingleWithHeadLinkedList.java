package Array;

import Node.Node;

/**
 * 特殊头结点-没有值的头结点
 * Node head = new Node(null,null);
 * pro: 不用区分插入删除的结点位置。begin middle last
 * cause: 因为自带null值头，所以不需要改变头部的指向，插入删除时。
 * */
public class SingleWithHeadLinkedList<T> implements _LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public SingleWithHeadLinkedList() {
        this.head = new Node<T>(null,null); ;
    }
    public SingleWithHeadLinkedList(Node<T> head) {
        this();//have head
        this.head.next = tail.next = head;//头尾确定好head
        tail = tail.next;//更新尾巴指向。最后一个才是尾巴。
    }
    public SingleWithHeadLinkedList(T[] arr) {
        this();//have head
        if (arr != null && arr.length > 0) {
            this.head.next = new Node<>(arr[0]);//赋第一个元素
            tail = this.head.next;//赋好尾巴
            int i = 1;
            while (i < arr.length) {
                tail.next = new Node<>(arr[i++]);
                tail = tail.next;
            }
        }
    }
    public SingleWithHeadLinkedList(SingleWithHeadLinkedList<T> list) {
        this();
        if (list != null && list.head.next != null) {
            this.head.next = new Node<>(list.head.data);
            tail = this.head.next;
            Node<T> node = list.head.next;
            while (node != null) {
                tail.next = new Node<>(node.data);
                tail = tail.next;
                node = node.next;
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int length() {
        int length = 0;
        //已经有头
        Node<T> cNode = head.next;
        while (cNode != null) {
            length ++;
            cNode = cNode.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index >= 0) {
            int j = 0;
            Node<T> node = this.head.next;
            while (node != null && j < index) {
                node = node.next;
                j++;
            }
            if (node != null) {
                return node.data;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (index >= 0 && data != null) {
            Node<T> node = this.head.next;
            int j = 0;
            while (node != null){
                node = node.next;
                j++;
            }
            if (node != null) {
                T old = node.data;
                node.data = data;
                return old;
            }
        }
        return null;
    }


    @Override
    public boolean add(int index, T data) {
       /*头部插入，中间插入，尾部插入*/
        if (data == null) {
            throw new NullPointerException("");
        }
        if (index < 0) {
            throw new NullPointerException("");
        }
        int j = 0;
        Node<T> pre = this.head;
        //find before index one
        //已有headNode 所以不用index-1
        while (pre.next != null && j < index ) {
            pre = pre.next;
            j ++ ;
        }
        //新插入，并修改指针指向
        Node<T> one = new Node<T>(data,pre.next);
        pre.next = one;
        //如果是末尾指针，把最后指针指给新加入的node
        if (pre == tail) {
            this.tail = one;
        }
        return true;
    }

    @Override
    public boolean add(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        this.tail.next = new Node<>(data);
        this.tail = this.tail.next;
        return true;
    }

    @Override
    public T remove(int index) {
        T old = null;
        if (index >= 0) {
            Node<T> node = this.head;
            int j = 0;
            while (node != null && j < index) {
                node = node.next;
                j++;
            }
            Node<T> current = node.next;
            if (current != null) {
                old = current.data;
                //如果是最后一个
                if (current == this.tail) {
                    this.tail = current;
                }
                //前节点的指针，指向当前节点的指针后面。
                node.next = current.next;
            }
        }
        return old;
    }
    /*
    * 删除所有包含data值的节点
    * */
    @Override
    public boolean removeAll(T data) {
        boolean remove = false;

        if (data != null) {
            //node前一个，front是当前节点。
            Node<T> node = this.head;
            Node<T> front = node.next;
            while (front != null) {
                if (front.data.equals(data)) {
                    //如果是尾巴，则继续更新尾巴
                    if (tail.data.equals(data)) {
                        this.tail = front;
                    }
                    //前节点指针
                    node.next = front.next;
                    front = node.next;
                    remove = true;
                } else {
                    //指针链接上
                    //?想了半天，应该就是把node 和 front 重置。重新链上。
                    node = front;
                    front = front.next;
                }
            }

        }
        return remove;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = this.head;
    }

    @Override
    public boolean contains(T data) {
        if (data != null) {
            Node<T> pre = this.head.next;
            while (pre != null) {
                if (data.equals(pre.data)) {
                    return true;
                }
                pre = pre.next;
            }
        }
        return false;
    }

    public void concat(SingleWithHeadLinkedList<T> list) {
        if (this.head.next == null) {
            this.head.next = list.head.next;
        } else {
            Node<T> node = this.head.next;
            while (node != null) {
                node = node.next;
            }
            node.next = list.head.next;//最后节点赋给另外list的头（自带头）的下一个
            this.tail = list.tail;//整个尾巴是list的尾巴
        }
    }

}
