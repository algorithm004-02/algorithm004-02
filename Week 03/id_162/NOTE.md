# 第三周笔记

##DFS
在图中使用BDFS搜索，思路清奇
![屏幕快照 2019-11-02 16.59.01](media/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-11-02%2016.59.01.png)

####代码模板 
**递归写法**

```python
visited = set() 

def dfs(node, visited):

#1.终止条件
    if node in visited:
    	return 
    	
#2.添加访问标识
	visited.add(node) 

#3.执行当下的代码逻辑
	# code ... 

#4.下探下一层
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)   # 直接在for循环中进入下一层
```

**非递归写法**

```python
#手动维护一个栈。在递归中，是递归维护一个栈

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


##BFS
####代码模板
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

##贪心算法
####贪心算法特性
- 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。（一般局部最优解都不是全局最优解）
2. 可以解决特定化最优问题：**求图中的最小生成树、求哈夫曼编码等**。
3. 不适用于工程、生活中的实际问题。
4. 一旦一个问题可以用贪心法来解决，那么贪心法是此问题最优解。
5. 基于其 高效性、答案较接近最优解，也可以用作**辅助算法or要求结果不精确的问题。**
6. 针对每个子问题，都**做出选择，不能回退**。
7. **动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。**


####何种情况下用到贪心算法?**问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。**这种子问题最优解称为最优子结构。##二分查找
####二分查找的前提1. 目标函数单调性(单调递增或者递减) 
2. 存在上下界(bounded)3. 能够通过索引访问(index ac

####代码模板
```python
left, right = 0, len(array) - 1while left <= right:   mid = (left + right) / 2   if array[mid] == target:      # find the target!!      break or return result   elif array[mid] < target:      left = mid + 1   else:right = mid - 1
```

####作业
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
思路：其实，思路就是一个二分查找，找到0的位置
1. l = 0， r = len-1; mid= (l+r)*0.5;
2. if l<mid,则l~mid单调递增，断点0在mid~r中。
3. if l>mid, 则断点0在l~mid中，mid~r单调递增。
4. 将有断点的半段作为新的半数组，递归查找。知道找到0为止。

