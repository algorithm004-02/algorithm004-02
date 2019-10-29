<<<<<<< HEAD
# NOTE

  

=======
# 学习笔记

## 数组、链表、跳表的基本实现和特性

### 数组

#### 数组的实现

以JavaScript为例：

```
let arr = [1, 2, 3]
```

#### 数组的特点

1. 当前高级语言都支持多种数据结构
2. 申请数组时，计算机会在内存中开辟一段连续的地址，可以通过内存管理器访问其中任意元素，因此时间复杂度都为O(1)
3. 进行插入操作时，需要同时将插入位置之后的元素，向后移动，因此时间复杂度为O(n)
4. 进行删除操作时，需要将相应元素删除，再将其之后的元素向前移动，因此时间复杂度为O(n)

### 链表

#### 链表的特点

1. 进行插入操作时，将前继节点的next指针指向插入的新节点，再将新节点的next指针指向下一个节点，因此时间复杂度为O(1)
2. 进行删除操作时，将前继节点的next指针直接指向被删除节点的下一个节点，因此时间复杂度为O(1)
3. 如果要访问链表中的任意位置，需要从头节点，一个一个节点向后查找，因此时间复杂度为O(n)

### 跳表

跳表主要在Redis中应用，它的设计目的是优化链表的查找操作时间复杂度为O(n)的问题。

#### 跳表的特点

1. 使用“升维”和“空间换时间”的思想，给链表进行加速。在实现中，就是为链表增加多级索引（log2n个），在查找时，可以先查找到目标附近的索引，之后再通过索引返回到原链表查找。相当于跳过了按顺序查找链表时的中间步骤，是一个从“粗调”到“微调”的过程。此时查找的时间复杂度为O(logn)
2. 在进行增加、删除操作时，需要进行更新索引的操作，因此增加、删除操作的时间复杂度会变成O(logn)
3. 由于跳表是在链表的基础上，增加了索引，因此它的空间复杂度也随之增加为O(n)

## 栈和队列的实现与特性

### 栈（Stack）

#### 栈的特点

1. 先入后出，FILO（First in last out）。
2. 添加、删除的时间复杂度都为O(1)
3. 由于栈内元素是无序的，查询需要进行遍历，时间复杂度为O(n)

### 队列（Queue）

#### 队列的特点

1. 先入先出，FIFO（First in first out）。
2. 添加、删除的时间复杂度都为O(1)
3. 由于栈内元素是无序的，查询需要进行遍历，时间复杂度为O(n)

### 双端队列（Deque：Double-End Queue）

#### 双端队列的特点

1. 双端队列在实战中经常使用，它是一个两端都可以进行Push和Pop的队列。
2. 添加、删除的时间复杂度都为O(1)
3. 由于栈内元素是无序的，查询需要进行遍历，时间复杂度为O(n)

### 优先队列（Priority Queue）

1. 插入操作，时间复杂度O(1)
2. 取出操作：时间复杂度O(n)，即按照元素的优先级取出
3. 优先队列实现的数据结构较为多样和复杂，可为heep、bst，treap。

# 作业总结

## [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

### 解法描述

遍历数组，同时用一个变量存储已整理数据在数组中的index，遇到与已整理最后一个数据不同的数据，则将其放到index+1的位置，并更新index

### 作业体会

1. 审题时对题目理解不够清晰，未能充分理解“你不需要考虑数组中超出新长度后面的元素”的含义，刚开始还有思考如何去除后续元素。
2. 执行结果如下：
    执行用时 : 112 ms, 在所有 javascript 提交中击败了55.03%的用户
    内存消耗 : 36.6 MB, 在所有 javascript 提交中击败了81.42%的用户
    对该结果不完全满意，希望能减少用时。
3. 不太理解题目中“并在使用 O(1) 额外空间的条件下完成”描述的含义

## [42. 接雨水](https://leetcode.com/problems/trapping-rain-water/)

### 解法描述

采用栈存储左边界，在碰到右边界时，依次求到之前所有左边界的面积，求和后为蓄水面积。

### 作业体会

1. 参考了https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
2. 参考了https://leetcode.com/problems/trapping-rain-water/discuss/406149/Javascript-Monotonic-stack-O(n)-solution
3. 最初也想到用栈的解法，但是没有进行求面积，导致计算出错

# 学习总结

### 学习心得

1. 课程中最大的收获是破除了遇到问题只想独立思考的想法。独立思考固然重要，但遇到难题时，没有必要自己钻牛角尖，而是要承认自己无法独立解决所有问题，虚心学习他人的优秀解法。学会“站在巨人的肩膀上”，才是进步的正确道路。
2. 老师的讲解十分出色，通俗易懂。但课后还需要自己多花时间练习，特别是将解法练成肌肉记忆，不能停留在能够解决问题即可的层次。

### 不足之处

1. 由于时间安排欠佳，导致预习周的学习任务积压到本周，加上平时时间分配不足，导致作业完成度太低。
2. 下周的安排是尽量在前两天完成课程的第一遍学习，之后留出足够的时间做习题，以及安排少量时间，进行从预习周开始的复习。

# 同学代码、总结Review

1. [https://github.com/algorithm004-02/algorithm004-02/pull/150/commits/c4a78845eb27f153fa7e9fbe27f4ec43e8c35ed8#diff-f1ae09cd27d925a24918697a9708353d](https://github.com/algorithm004-02/algorithm004-02/pull/150/commits/c4a78845eb27f153fa7e9fbe27f4ec43e8c35ed8#diff-f1ae09cd27d925a24918697a9708353d)

2. [https://github.com/algorithm004-02/algorithm004-02/pull/148/commits/8c4a0ae7adb4db7795002e78b34881302c4027b3#diff-9b9f172215f9184c1f46a52a6f774c87](https://github.com/algorithm004-02/algorithm004-02/pull/148/commits/8c4a0ae7adb4db7795002e78b34881302c4027b3#diff-9b9f172215f9184c1f46a52a6f774c87)

3. [https://github.com/algorithm004-02/algorithm004-02/pull/146/commits/6e743245df52400a3243e0f9a75754edf6ea664a#diff-330360f927a459a2b39cc7e28792e25c](https://github.com/algorithm004-02/algorithm004-02/pull/146/commits/6e743245df52400a3243e0f9a75754edf6ea664a#diff-330360f927a459a2b39cc7e28792e25c)

4. [https://github.com/algorithm004-02/algorithm004-02/pull/151/commits/ef342fe372362f01c46503b82f342e23ddd9b1dd#diff-5b592146024ef7f23073f244e2bfe590](https://github.com/algorithm004-02/algorithm004-02/pull/151/commits/ef342fe372362f01c46503b82f342e23ddd9b1dd#diff-5b592146024ef7f23073f244e2bfe590)

5. [https://github.com/algorithm004-02/algorithm004-02/pull/152/commits/1ff08475ef34faf9c19b1914ae270312722d1118#diff-3a75b4dc6c5d3d7884cb1659c76bb0a9](https://github.com/algorithm004-02/algorithm004-02/pull/152/commits/1ff08475ef34faf9c19b1914ae270312722d1118#diff-3a75b4dc6c5d3d7884cb1659c76bb0a9)
>>>>>>> upstream/master
