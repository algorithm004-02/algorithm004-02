<<<<<<< HEAD
# NOTE

  

=======
# Java 的 HashMap

## 构造函数

确定 初始容量 `initialCapacity` 和 负载因子 `loadFactor` 的值及其合法性。

设定 `threshold = capacity * loadFactor`，当 `HashMap` 的 `size` 到了 `threshold` 时，就进行扩容。

> 构造一个和指定 Map 有相同 mappings 的 HashMap 时，初始容量能充足的容下指定的 Map，负载因子为 0.75。

## 数据结构

### JDK 1.8 以前

数组+ 单链表

### JDK 1.8 及以后

数组+链表+红黑树

当链表长度大于 `TREEIFY_THRESHOLD` （默认为 8）时，将链表转换为红黑树，当然小于`UNTREEIFY_THRESHOLD` （默认为 6）时，又会转回链表以达到性能均衡。

## 同步

线程不安全，若有并发需求，可使用 `HashTable` 数据结构，或通过下面语句进行同步：

```java
Map m = Collections.synchronizeMap(hashMap);
```

# NOTE

## 1. Map

> key-value 对，key 不重复。

## 2. SET

> 不重复元素的集合

其实就是 `Map`，将元素作为 `key`，而 `value` 恒为 `PRESENT`。

```java
private static final Object PRESENT = new Object();
```

## 3. 树的遍历顺序

- 前序遍历：父左右
- 中序遍历：左父右（对于二叉搜索树，中序遍历可得到有序的结果）
- 后序遍历：左右父

## 4. 递归代码模板

> 寻找并拆解重复子问题

```java
public void recur(int level, int param) {

  // 递归终结条件
  if (level > MAX_LEVEL) {
    return;
  }

  // 处理当前层逻辑
  process(level, param);

  // 下探到下一层
  recur( level: level + 1, newParam);

  // 清理当前层

}
```

## 5. 分治

### 5.1 基本特征

1. 问题缩小到一定规模容易解决

2. 分解成的子问题是相同种类的子问题，即该问题具有最优子结构性质

3. 分解而成的小问题在解决之后要可以合并

4. 子问题是相互独立的，即子问题之间没有公共的子问题

### 5.2 分治的处理步骤

1. 分解成很多子问题

2. 解决这些子问题

3. 将解决的子问题合并从而解决整个大问题

### 5.3 分治代码模板

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```
>>>>>>> upstream/master
