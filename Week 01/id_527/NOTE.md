<<<<<<< HEAD
# NOTE

  

=======
# 作业

## 一、用add first或add last这套新的API改写Deque的代码

```
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

## 二、分析Queue和Priority Queue的源码

### Queue
> 继承自 `Collection` ，是集合家族的一员

主要提供了两组方法：

1. 当数据不符合要求是直接抛出异常。

    - `boolean add(E e);` 将元素插入队列

    - `E remove();` 将队首的元素删除，队列为空则抛出异常

    - `E element();` 获取队首元素，但不移除，队列为空则抛出异常

2. 功能和第一组对应，但数据不符合要求时不会抛异常。

    - `boolean offer(E e);` 将元素插入队列，与 `add` 相比，在容量受限时应该使用这个

    - `E poll();` 将队首的元素删除，队列为空则返回 `null`

    - `E peek();` 获取队首元素，但不移除，队列为空则返回 `null`

### Java Priority Queue

> `PriorityQueue` 使用跟普通队列一样，唯一区别是 `PriorityQueue` 会根据排序规则决定谁在队头，谁在队尾。存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器。

特点

- 普通队列都是先进先出的，但是优先级队列是根据优先级进行确定的，优先级最高的先出队列。
- 优先级队列类似于一棵完全二叉树，其内部实现使用的是数组。
- 优先级队列在数组中其元素不一定是完全有序的，但是在出队列时，其元素是有序的。
- 优先级队列插入和删除元素时，都需要对队列中的元素进行调整，其中 `remove()` 和 `add()` 方法的时间复杂度为 `O(log n)` ,而 `remove(Obejct obj)` 和 `contaions()` 方法需要 `O(n)` 时间复杂度，取对头元素只需要 `O(1)` 时间。
- 优先级队列是非同步的，队列中不允许使用 `null` 元素。

# NOTE

每个问题都可能右多种解法，各有优劣，可以将所有解法都写一遍，对比其时间复杂度和空间复杂度，再择优解题。常见解题套路：

- 双指针法

    - 快慢指针法

    > 两个指针都从头出发，快指针移动速度比慢指针快。

    - 对撞指针法

    > 一个指针从头出发，一个指针从尾出发，最后两个指针碰头。

    回文字符串、移动零、盛水最多的容器、三数之和、删除排序数组中的重复项、是否环形链表以及查找环的起点等。

- 单调栈

    > 栈内的元素一定是单调的，要么单调递增，要么单调递减。

    如果单调栈维护单调递减序列：假如将要入栈的元素比栈顶元素大，那么就将栈顶元素移出栈，然后继续判断将要入栈的元素与栈顶元素的大小关系，循环移出比将要入栈元素大的栈顶元素，直到将要入栈的元素比栈顶元素小，才将将要入栈的元素移入栈。同理维护单调递增的元素也是如此。

    接雨水、柱状图中最大的矩形等。
>>>>>>> upstream/master
