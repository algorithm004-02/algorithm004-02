# NOTE

week 07：

1、位运算

​	大学课程的电路类比

2、LRU Cache

​	自己实现的代码--使用hashMap和双向链表实现 LRU：

```
@Data
public class MyLRUCache {
    //用于定位数据 以及装载出现过得数据
    Map<Integer, Node> map;
    //缓存的容量大小
    Integer capacity;
    //双向列表头结点,靠近这里的元素是旧的
    Node<Integer, Integer> head;
//    双向列表尾部节点，靠近这里的元素是新的
    Node<Integer, Integer> tail;

    MyLRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        head = new Node<>(0, 0);
        tail = new Node<>(0, 0);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        //如果这个值已经被访问过了
        if (map.containsKey(key)) {
            Node<Integer,Integer > node = map.get(key);
            swapElement(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            //有可能是不同次输入重复的key，值要更新
            node.value = value;
            swapElement(node);
        } else{
            Node node = new Node(key, value);
            if (map.size() < capacity) {
                map.put(key, node);
                addLast(node);
            } else {
                Node<Integer, Integer> first = head.next;
                Node<Integer, Integer> second = first.next;
                head.next = second;
                second.prev = head;
                map.remove(first.key);
                map.put(key, node);
                addLast(node);
            }
        }

    }

    private void addLast(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 将
     * @param node
     */
    private void swapElement(Node<Integer, Integer> node) {
        //当前节点的后节点
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;

        addLast(node);
    }
```

​	3、排序算法

   推荐马老师的视频，唐诗宋词类比记忆法：https://www.bilibili.com/video/av46648286