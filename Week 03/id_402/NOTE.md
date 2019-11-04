# NOTE

  <h1>Week 3 总结</h1>

<br>

<h1> 树的遍历</h1>

**DFS (Depth-First-Search)：深度优先搜索**

**示例代码**

**1、递归（记忆滚瓜烂熟）**

```python
visited = set() 

def dfs(node, visited):
if node in visited: # terminator 一开始递归的终止条件
	# already visited 已经访问过
	return 

	visited.add(node) 处理当前层

	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: //判断 下一个节点是否被访问过
			dfs(next_node, visited)
```

**BFS：广度优先搜索**

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

<h1>贪心的实现、特性及实战题目解析</h1>

每一步中都采取当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或者最优的算法。

<h2> 定义</h2>.

<h2>贪心算法与动态规划的不同 </h2>.贪心算法与动态规划的不同在于他对每个子问题的解决方案都作出选择，不能回退。工台规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。



<h2> 贪心法可以解决一些最优化问题</h2>.如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。
一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

<h2> 适用贪心算法的场景</h2>.简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

<h2> 难点</h2>.如何证明能够使用贪心算法，即所有子问题的最优解释最终结果的最优解。





<h1>二分查找 <h1>
    <h2>
        二分查找的前提
    </h2>

1. 目标函数单调性（单调递增或者递减）有序序列进行查找
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

<h2>代码模板</h2>

```python
left, right = 0, len(array) - 1 
while left <= right: 
  mid = (left + right) / 2 
  if array[mid] == target: 
    # find the target!! 
    break or return result 
  elif array[mid] < target: 
    left = mid + 1 
  else: 
    right = mid - 1\
    #注意理解各个操作的含义，不要死记硬背，灵活应用。

```

