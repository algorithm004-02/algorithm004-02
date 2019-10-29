<<<<<<< HEAD
# NOTE

  

=======
# 笔记
- 想不出来不用一直思考，每次学习算法都碰上难题，然后打击自信心，最后不了了之。及时看解答，反复得到反馈更重要。
- 写代码的时候，先写结构和大概的思路，然后补充细节和具体的方法，更快、更能减少失误
- 算法核心思想。1 升维；2 空间换时间。计算机只会 if-else \ for loop ，所以需要去寻找最近的重复逻辑，
  如果没有思路的时候，先看简单的情况，一步一步查找最小的重复单元，数学归纳法

# 新的 API 改写 Deque 的代码
 见上传的 DequeDemo.java 文件

# Queue 和 PriorityQueue 源码学习
Java 8 中的 Queue 类
queue 是一个先进先出的队列。
- 继承 java.util.Collection 的接口，它的实现类有 AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue
- 有两类方法
  a. 操作失败后抛异常。add / remove / element
  b. 操作失败后返回特殊值，null 和 false 。 offer / poll / peek
  add / offer 方法在队列尾部插入新元素
  remove / poll 方法在队列头部删除元素
  element / peek 方法获取队头元素，并不操作队头元素
- 不能插入值为 null 的元素

Java 8 中的 PriorityQueue 类
数据元素没有限制的优先级队列，队列的顺序由元素的 Comparable \ Comparator 方法决定（队列头部是按顺序排序的
最后一个元素）。
- 继承 java.util.AbstractQueue 的类
- 底层数据的操作基于 Balanced Binary Tree （平衡二叉树）
  O(long(n)) 时间复杂度的方法：offer / poll / remove / add
  O(n) 时间复杂度的方法：remove(Object) / contains(Object)
  O(1) 时间复杂度的方法：peek / element / size
- 初始化时，会确认初始的大小，

>>>>>>> upstream/master
