# NOTE
#### ############################################     week01         ############################################################
# 1、改写Deque代码

```java
Deque<String> deque = new LinkedList<String>();
deque.addFirst("b");
deque.addLast("c");
deque.addFirst("a");
System.out.println(deque);
String str = deque.peek();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.pop());
}
System.out.println(deque);
```

# 2、Queue的Priority Queue的源码分析

## api：

    add和offer方法
      1、判空，添加数据不能为null；
      2、根据size与数组长度比较，判断是否扩容（先判断当前队列容量是否小于64，如果是扩容一倍容量，如果不是，扩容原容量的1/2）；
      3、判断添加的是不是第一个元素，如果不是，进行调整，增加完元素之后，我们需要进行调整才能维护最大堆或最小堆的性质。而这里的这个调整在堆中被称为上浮（对应的方法是siftUp）
      
    peek方法和poll方法（默认比较器为自然数排序，最小堆）
      1、peek取出堆中最小值元素
      2、取出堆中最小值的同时，移除该数据对堆操作：下沉（siftDown）
        


## 特性    

1. priorityQueue是基于优先级堆来实现的无界优先队列，是在JDK1.5之后引入的类；
2. 优先队列的元素按照它们的自然排序顺序排列，或者根据使用的构造方法提供的比较器来进行排序；
3. 优先队列不允许null元素；
4. 优先队列不允许插入非可比的对象，有可能会抛出ClassCastException，比如对int排序，你添加了一个字符串类型的元素。
5. 该优先队列每次取出的元素都是最小的。接口offer, poll, remove(),add方法，查询时间都是O(log(n))，
6. 优先队列迭代器迭代的顺序无法保证，如果想有序遍历，请考虑使用Arrays.sort(priorityQueue.toArray())；而对于remove(Object) and contains(Object)方法，查询是线性时间；而对于peek, element, and size方法，查询是常数时间。
7. 该优先队列不是线程安全的，如果要在线程安全的场景下使用，建议使用线程安全的PriorityBlockingQueue类（优先级阻塞队列）；





# 3、学习总结

​	经过一周的学习，总结以下点：

​		1、题目的练习五毒神掌功效好，进行题目练习时，考虑多种方法实现时深刻体会到老师所说的中心思想：升维和空间换时间；

​		2、经过练习后总结一下规律：

​			**去重、移动元素、检测环**等相关问题可以用快慢指针思路解决问题；

​			对于**合并、排序、反转等链表**操作可以使用递归思路解决问题，因为对链表的这些操作都符合递归的最小问题重复性原则，第二个思路就是使用一个指针指向结果，通过移动指针将需要得到的数一步步的粘贴在结果上

​		3、对于**有序**的数组链表等操作可以使用左右双指针逼近思路解决问题。



​    
​    

