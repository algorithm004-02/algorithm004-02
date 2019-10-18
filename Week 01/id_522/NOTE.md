# NOTE

2019-10-13 
一、本周先看了，LRU 的JAVA 版本，参考着写了python 版本的；

感觉就是再写一个2个维度 的算法，不仅要注意hash 里面的实现，还要实现双向链表。

我用了字典，一开始吧头节点和尾节点放到了hash 里面，后来发现可以放到外边，不进入hash

这样，字典的长度，就是LRU 的长度了。


二、而后开始做leetcode第26 题，发现如果在遍历中，改变数组的长度，就有问题，

如果用while 循环来，就需要try 来处理；所以，想到了双指针方法，因为是已经排好序的数组，这个很重要

2019-10-14 ,

一、今天看了本周的第一个视频，感觉跳表，讲的比王争老师多了一些，我对跳表的理解也有进步，只是每次插入删除，涉及到了维护索引，也是有成本的。
而老师说的升维和空间换时间，真的有体会。特别是炒股票的题。

二、我按照老师说的，看了JAVA 的源码
 220:   public int indexOf(Object e)
 221:   {
 222:     for (int i = 0; i < size; i++)
 223:       if (equals(e, data[i]))
 224:         return i;
 225:     return -1;
 226:   }

这里，我们可以清楚的看到，e 是否在ArrayList中，是需要遍历的

 354:   public void add(int index, E e)
 355:   {
 356:     checkBoundInclusive(index);
 357:     modCount++;
 358:     if (size == data.length)
 359:       ensureCapacity(size + 1);
 360:     if (index != size)
 361:       System.arraycopy(data, index, data, index + 1, size - index);
 362:     data[index] = e;
 363:     size++;
 364:   }
在这几行代码中，看到了边界检查，扩容，整体后移靠复制，定点插入不简单。

三、在学习  LinkedList<AnyType> 这个里面，比较震撼的是这三个复制，时间复杂度差别大。 

/**
   *  Returns a deep copy of the list
   *  Complexity: O(n^2)--------------------------时间是平方的！！！
   */
   public  LinkedList<AnyType> copy1()
   {
      LinkedList<AnyType> twin = new LinkedList<AnyType>();
      Node<AnyType> tmp = head;
      while(tmp != null)
      {
         twin.addLast( tmp.data );  #这里addLast 是O(n)
         tmp = tmp.next;
      }

      return twin;
   }

还有一个细节，在声明Node 中赋值this.next
   public void addFirst(AnyType item)
   {
      head = new Node<AnyType>(item, head);
   }

public boolean removeLastOccurrence(Object o) 这个是从后面开始搜，搜到就删除。 




2019-10-18 

昨天把视频都看完了，预习题目，加上实战题目加作业，感觉压力山大。

先是按照老师的做法，看了java 的Queue ，这是一个接口。
比较值得关注的是，remove() 和 poll() ,都是去掉左边的头结点。而peek element 不是，只是查看


对于源码分析 PriorityQueue
PriorityQueue是非线程安全的，所以Java提供了PriorityBlockingQueue（实现BlockingQueue接口）用于Java多线程环境。如果一个用户类Customer，它没有提供任何类型的排序。当我们用它建立优先队列时，应该为其提供一个比较器Comparator对象。

 

接下来，看了python heapq 和container .

对于优先级队列，python 就是这样解决的。
里面学到的是 heapq.heappushpop(heap, item) 这样的一步操作，有点像一步两动，但要注意细节，并且
知道这样的效率较好。
heapq.heapreplace(heap, item) 说明了，
The value returned may be larger than the item added. If that isn’t desired, consider using heappushpop() instead. Its push/pop combination returns the smaller of the two values, leaving the larger value on the heap.
先压入队列再拿出来，肯定是最小的，但replace 是先出后压入。 我个人感觉这个函数应该命名为heappop_push()

而后学习了collections ,这真的是个好东西
1、namedtuple()，感觉就是轻量级的dict，，我再想如果把用字典实现的两个数之和，用它，是不是更节约内存？
2、deque 这一个，实现list，stack ，queue 都行；Rotate the deque n steps to the right. If n is negative, rotate to the left.
3、Counter ，就是计数字典，
>>> c = Counter(a=4, b=2, c=0, d=-2)
>>> list(c.elements())
['a', 'a', 'a', 'a', 'b', 'b']  注意这里的忽略。

4、OrderedDict ，可以用它实现JAVA LinkedHashMap ， move_to_end()方法很好。
   如果怕手写指针的麻烦。用它就好。
5、defaultdict ，对于它需要Using list as the default_factory 
>>> s = [('yellow', 1), ('blue', 2), ('yellow', 3), ('blue', 4), ('red', 1)]
>>> d = defaultdict(list)
>>> for k, v in s:
...     d[k].append(v)
...
>>> d.items()
[('blue', [2, 4]), ('red', [1]), ('yellow', [1, 3])]
另一个

>>> s = 'mississippi'
>>> d = defaultdict(int)
>>> for k in s:
...     d[k] += 1
...
>>> d.items()
[('i', 4), ('p', 2), ('s', 4), ('m', 1)]


本周，感觉作业量大，很大，每个做5遍，时间真不够用。
1、升维，空间换时间，在收集雨水的题目中，用了动态规划，比左右夹逼，空间多用，但理解较容易。

2、从嵌套循环，到左右夹逼，这个需要理解，反复。

3、超哥说的，学习方法，这个才重要，重要的是不是你脑袋里有多少干货，最重要的是你知道在哪找这些干货。

4、所谓提高了，就是见识了高手是怎么干的，原来还可以这么干，扩展了自己的知识边界。

5、我也想到过，除了if else ，for while ，再就是递归，但听超哥一说，豁然开朗。

6、超哥，真是肺腑之言。



