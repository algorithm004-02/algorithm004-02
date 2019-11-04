# 问题

## 使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方

同 [LeetCode 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)，找到旋转数组中的最小值即是无序的地方。

- 当 `nums[mid] > nums[right]` 说明在 `mid` 左半边的递增区域, 说明最小元素在 `> mid` 区域

- 当 `nums[mid] <= nums[right` 说明在 `mid` 右半边的递增区域, 说明最小元素在 `<= mid` 区域

> 二分查找需要注意 `int mid = (left + right) / 2` 中，`left + right`可能出现溢位情况，因此更优的写法是 `int mid = left + (right - left) >> 1`。

# NOTE

## 一、树/图的搜索

> 图有环状关系，遍历时应比树多一个是否已经遍历过该结点的判断，通常用 `Set` 实现。

### 1.1 DFS 代码模板（递归写法）

```python
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
```

### 1.2 DFS 代码模板（非递归写法）

> 自己维护一个栈

```python
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
	...
```

### 1.3 BFS 代码模板

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
	...
```

## 二、贪心算法

> 在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。

贪心算法适用的前提时：局部最优策略能导致产生全局最优解。

### 2.1 基本思路

- 建立数学模型来描述问题

- 把求解的问题分成若干个子问题

- 对每个子问题求解，得到子问题的局部最优解

- 把子问题的解局部最优解合成原来问题的一个解

### 2.2 贪心算法存在的问题

- 不能保证求得的最后解是最佳的

- 不能用来求最大值或最小值的问题

- 只能求满足某些约束条件的可行解的范围

### 2.3 贪心算法的实现框架

```
从问题的某一初始解出发：
while (朝给定总目标前进一步)
{
    利用可行的决策，求出可行解的一个解元素。
}
由所有解元素组合成问题的一个可行解；
```

## 三、二分查找

### 3.1 算法要求

- 顺序存储结构

- 有序排列

### 3.2 二分查找代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = left + (right - left) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

