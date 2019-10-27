## Week01 - 学习总结

### 数组Array

- 实现：内存连续地址
- 特性：
    - 1、读取速度快 -- O(1)
    - 2、添加或删除指定索引位置的元素时，需要移动索引后面的数据 -- O(n)

### 链表Linked List

- 实现：
    - 1、每一个元素都是一个节点Node
    - 2、Node：包含一个值Data，一个指针Next
    - 3、Data：数据，Next：指向下一个元素
    - 4、复杂的链表可能包含多指针
- 分类：
    - 1、单向链表 Head -> Next -> ... -> Tail -> None
    - 2、双向链表 Head -> Next -> ... -> Tail -> None (None <- Head <- ... <- Prev <- Tail)
    - 3、循环链表 Head -> Next -> ... -> Tail -> Head

### 跳表Skip List

- 实现：
    - 1、在链表的基础上增加多级索引
- 特性：经过添加和删除之后，索引不一定工整 
- 应用：Redis

### 栈Stack

- 先入后出；添加、删除皆为：O(1)
- 查询为：O(n)

### 队列Queue

- 先入先出；添加、删除皆为：O(1)
- 查询为：O(n)

### 双端队列Deque

- 两端可以进出的Queue
- 添加、删除元素为：O(1)
- 查询为：O(n)

### 优先队列Priority Queue

- 添加为：O(1)
- 取出为：O(logn)，按元素优先级取出
- 底层具体实现的数据结构较为多样和复杂：heap、bst、treap

### 数组、链表、跳表各操作时间复杂度

|  | 数组 | 链表 | 跳表 |
| --- | --- | --- | --- |
| prepend | O(1) | O(1) | O(1) |
| append | O(1) | O(1) | O(1) |
| lookup | O(1) | O(n) | O(logn) |
| insert | O(n) | O(1) | O(logn) |
| delete | O(n) | O(1) | O(logn) |

### 改写示例代码 - Deque
```java
Deque<String> deque = new LinkedList<String>();

deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (!deque.isEmpty()) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

### 分析Queue和Priority Queue的源码

**Queue**
后补

**Priority Queue**
后补


