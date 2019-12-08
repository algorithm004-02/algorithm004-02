# NOTE

### 遍历搜索

在树（图/状态集）中寻找特定结点

* 每个节点都要访问一次
* 每个节点只需要访问一次
* 对节点的访问顺序不限
    * 深度优先：Depth-First-Search （递归或栈）
    * 广度优先：Breadth-First-Search（队列）
    * 优先级优先（更适合现实业务场景）
        * 启发式搜索（推荐算法）
        * 估价函数

#### 数据结构

```java
// Java

public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
        
#### 熟练代码模板
    
* DFS深度优先

```python
# 递归
visited = set() 

def dfs(node, visited):
if node in visited: # terminator
	# already visited 
	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)

# 非递归
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
```

* BFS广度优先

```python
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 
	visited.add(start)

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
```


### 贪心算法Greedy

#### 定义

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而**希望导致**结果是全局最好或最优的算法。

#### 与动态规划的不同

* 贪心算法
    * 子问题做最优判断
    * 不能回退
* 动态规划
    * 子问题做最优判读，保存运算结果
    * 根据以前的结果对当前进行选择，有回退功能

#### 适用贪心算法的场景

* 贪心法可以解决一些最优化问题如：
    * 求图中的最小生成树
    * 求哈夫曼编码
* 对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。

#### 结论

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

* **难点：怎么证明问题是可以用贪心算法**
* 贪心的角度不同


### 二分查找

#### 前提条件

1. 目标函数单调性（单调递增或或递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

#### 熟练代码模板

```
left, right = 0, len(array) - 1 
while left <= right: 
    mid = (left + right) / 2 
    if array[mid] == target: 
        # find the target!! 
        break or return result 
    elif array[mid] < target: 
        left = mid + 1 
    else: 
        right = mid - 1
```

### 寻找中间旋转位 - 作业

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

```java
public int find_rotate_index(int[] nums) {
    if (nums == null || nums.length == 0)
        return -1;
    if (nums.length == 1)
        return 0;

    int left = 0, right = nums.length - 1;

    if (nums[right] > nums[left])
        return 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1])
            return mid + 1;

        if (nums[mid - 1] > nums[mid])
            return mid;

        if (nums[mid] > nums[0]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return 0;
}
```


