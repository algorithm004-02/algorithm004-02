<<<<<<< HEAD
# NOTE

  

=======

Queue: 队列

1. Queue本身为一个接口，有很多具体实现类，常见的有：ConcurrentLinkedDeque, ConcurrentLinkedQueue, LinkedList等

2.特性：先进先出，入队出队时间复杂度都是o(1)

3. 方法：
add(E e) 入队 对应：offer(e)
remove() 出队 对应：poll()
element() 查看队首元素 对应：peek()
前面的方法操作失败时抛出异常，后面的返回特殊值

PriorityQueue: 优先队列

1. 继承Queue接口，同时还继承Serializable, Iterable<E>, Collection<E>

2. 特性：优先级高的先出。原理是入队时将优先级最高的放入队首。所以入队时间复杂度是o(logN)，出队是o(1)。

3. 方法：
```$xslt
add(E e) 入队 对应：offer(E e)
clear() 清空队列
comparator() 设置排序规则
contains(Object o) 是否存在对象
iterator() 返回迭代器
peek() 查看队首元素
poll() 查看并出队
remove(Object o) 删除指定元素
size() 返回队列长度
spliterator()
toArray() 转化为数组
toArray(T[] a) 转化为数组
```

入队源码：
```$xslt

public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}

private void siftUp(int k, E x) {

    // 设置了排序规则，用自定义的
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
    // 否则用默认的
        siftUpComparable(k, x);
}

// 自定义排序规则
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}

// 默认规则
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
```



>>>>>>> upstream/master
