# 笔记
- Java 源码中的数据结构需要做到不仅会用，还得了解底层结构和熟悉实现的方法，这部分平时做的少，需要补充。
- 这周学习的内容主要是：哈希表、映射、树、二叉搜索树、递归、回溯，与上周相比困难不少，完全自己思考做完的化太多时间，其他的先按老师说的先看别人的方法。
- 链表是特殊化的树（多个next指针）、树是特殊化的图（没有环）
- 递归和回溯的本质还是重复性，最近的重复性（分治）、最优的重复性（动态规划），通过找到重复性，分解问题，组合答案
- 递归的模板
  a. 递归终结条件
  b. 处理当前层逻辑
  c. 转到下一层
  d. 清扫当前层状态步一步查找最小的重复单元，数学归纳法
  ```
  public void recur(int level, int param) {
      // terminator
      if (level > MAX_LEVEL) {
          // process result
          return ;
      }
  
      // process current logic
      process(level, param);
  
      // drill down
      recur(level:level+1, newParam);
  
      // restore current status
  }
  ```

# HashMap 源码学习
Java 8 中的 HashMap 类
- HashMap 实现了Map接口，继承自AbstractMap，并且是LinkedHashMap的父类。
- HashMap 每个元素为桶（bucketed）的哈希表，当一个桶里的元素大于8时，会转换为一个红黑树。
- HashMap 是非线程安全的，允许 key 为 null 值。线程安全可以 concurrentHashMap 。
- HashMap 中的一些属性 
  a. capacity，哈希表的容量大小，值为 2 的幂，默认初始化为 16，最大为 2 的 30 次方。包含了哈希表中的所有元素。
  b. size, 哈希表的实际大小。
  c. loadFactor，负载因子，用于计算扩容时的阀值。
  d. threshold, 扩容的阀值。当哈希表size大于阀值时，就开始扩容`resize()`。
- 常用的方法
  a. get，根据键获取元素。通过计算 key 的哈希值 hashcode ，查找 hashcode 对应的第一个元素，如果 key 相同，则找到；如果 key 不同，则看元素类型是否为 TreeNode ，如果是，查询红黑树找到对应节点，如果不是的话遍历链表找到对应节点。
  b. put，根据键添加元素。如果 map 数组原始为空，则需要先扩容，通过 hash(key) & (length-1) 映射数组是否有值，没有的话直接插入，有的话，判断链表长度，当链表长度超过8时，需要重构为红黑树插入，否则直接插入链表。元素插入后还需要根据实际大小判断扩容。