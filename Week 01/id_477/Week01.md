引用自学号282的同学，感觉对方总结的很好

#### 数组、链表、跳表。
#### 栈、队列、优先队列、双端队列。
>leetcode 题目纠结很长时间无从下手，挺老师讲课时感觉听懂了。第二次还是无从下手。现在在手抄leetcode代码，加强记忆。今后每天都要在算法投入更多时间
数组、链表、跳表
数组
数组是由一段连续的内存空间构成，内存控制器中会存放数组的地址。由于数组是连续的，所以数组的插入和删除平均复杂度为O(n)，查询复杂度为O(1)，且数组会有溢出，因此在解答数组过程中需要注意数组的边界问题。
目前做题过程中，数组遇到挺多问题的，常用的解答方法包括：
#### 暴力法遍历
一般暴力法在解题中用的很少，主要是因为复杂度的问题，但是暴力法基本有助于理解题目意图。
暴力法还可以延伸出从头部开始遍历还是从尾部开始遍历两种思想
#### 双指针法
双指针法中经常遇到的问题包括了边界的问题，边界从哪里开始，哪里结束，有很多巧妙的方法可以使用，需要巩固。
### 空间换时间
引入新的数组空间，用空间换时间
用栈来辅助解决问题
#### 链表
链表与数组有所不同，不需要连续的内存空间，链表的next指针指向下一个元素，双向链表则额外保存了previous指针，链表的尾部指向null
```python
Class Node:      
    def __init__(self, data):      
        self.val = data       
        self.next = None   
```
链表的插入与删除复杂度都为O(1)，由于链表需要从头到尾遍历才能查找元素，因此访问的复杂度为O(n).
链表的操作需要注意，插入链表如果写的不熟练，容易犯错，比如会把插入结点指向自身。
目前用到的解答方法：

#### 递归
021这题用递归解决，后续根据实际遇到问题，继续总结
由于链表的访问复杂度为O(n),为了解决链表的访问复杂度问题，采用了升维的思想，引入了跳表。
小技巧，引入哨兵结点。
#### 跳表
跳表的思想是引入了多级索引的概念，假设链表结点个数为n,则一级索引为n/2，第二级索引为n/2^2, 第K级索引为n/2^k
时间复杂度分析：
假设索引有h级，则n/2^h = 1，则h = log2(n)1
索引的高度:logn，每层索引遍历的结点个数:3.
在跳表中查询任意数据的时间复杂度就是 O(logn).
空间复杂度为O(n)，等差数列求和。

#### 栈，队列，双端队列，优先队列
#### 栈Stack
LIFO，后进先出
添加删除均为O(1)
阅读Java源代码，掌握核心思想.

#### 队列Queue
FIFO，先进先出。Java中实现是以Interface的形式实现
添加删除均为O(1).
Queue有两套API，add, remove, element有exception, offer, poll, peek则返回null.
阅读Java源代码。

#### 双端队列Deque
头尾都可以进，Doubleended queue.
添加删除复杂度都为O(1)，查询复杂度为O(n)。

课后作业
改写API为addLast, peekLast
```java
Deque<String> deque = new LinkedList<String>();  
deque.addLast("a");  
deque.addLast("b"); 
deque.addLast("c"); 
System.out.println(deque);
String str = deque.peekLast(); 
System.out.println(str); 
System.out.println(deque);
while (deque.size() > 0) {
  System.out.println(deque.pollLast()); 
}
System.out.println(deque);
```
优先队列Priority Queue
插入操作复杂度O(1)，查询的复杂度为O(logn), 按优先级取出
