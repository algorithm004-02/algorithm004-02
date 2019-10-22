# NOTE

## 用 add first 或 add last 这套新的 API 改写 Deque 的代码
```
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("b"); 
    deque.addFirst("c"); 
    deque.addLast("a");
    System.out.println(deque);
    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);
    while (deque.size() > 0) {
        System.out.println(deque.poll()); 
    } 
    System.out.println(deque);

```




# 分析 Queue 和 Priority Queue 的源码
- Queue标准API是 offer peek poll
- offer:进入队列
- peek:查看队首位置元素(只是看看而已，不出队列)
- poll:队首位置出队列
- Queue扩展API是 add element remove
- 标准API vs 扩展API的区别是数据违反约定时标准API返回特殊值，扩展API抛出异常
- add remove 继承自父类 Collection，element是新添加，iterator是继承自父类的父类Iterator

---

- PriorityQueue的父类有AbstractQueue、AbstractCollection、Queue、Collection、Iterator、Serializable
- 底层数据存储采用 堆 数据结构，基于数组结构的二叉树形式
- 父节点所在的数组节点下标：parent = (i - 1) >>> 1，通过移位操作代替除法，提高执行效率
- 优先级特性的维护是在元素变更的时候，即add remove offer poll被调用时，time complexity是O(logN) 
- 优先级比较的依据：首先是是否配置了比较器 Comparator；再者元素是否实现的Comparable接口 

## 

  

