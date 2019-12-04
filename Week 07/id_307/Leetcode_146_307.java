class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.head = this.tail = null;
    }
    private void addFirst(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        map.put(key, node);
        moveToFirst(node);
    }

    private void concat(Node a, Node b) {
        if (a != null && b != null) {
            a.next = b;
            b.previous = a;
        }
    }
    private void removeLast() {
        Node temp = tail;
        //头尾一样
        if (tail == head) {
            tail = head = null;
        } else {
            tail = tail.previous;
            tail.next = temp.previous = temp.next = null;
        }
        map.remove(temp.key);
    }
    private void moveToFirst(Node node) {
        //头节点
        if (node == head)
            return;
        if (tail == null) {
            head = tail = node;
            return;
        }
        //尾节点
        if (tail == node) {
            tail = node.previous;
            tail.next = null;
            node.previous = null;
        // 中间节点
        } else {
            concat(node.previous, node.next);
            node.previous = null;
        }
        concat(node, head);
        head = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            moveToFirst(target);
            return target.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            target.value = value;
            get(key);
        } else {
            if (size + 1 > capacity) {
                removeLast();
                size--;
            }
            addFirst(key, value);
            size++;
        }
    }

    class Node {
        int key;
        int value;
        Node previous;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */