### 第13课 字典树和并查级
##### 字典树 Trie
字典树的数据结构
**Trie 树** ，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），
**应用**：经常被搜索引擎系统用于文本词频统计。
**优点**：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

**字典树的核心思想**
- Trie 树的核心思想是空间换时间
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
**字典树的基本性质**
- 结点本身不存完整单词
- 从根结点到某一结点，路径上经过的字符串连接起来，为该结点对应的字符串
- 每个结点的所有子结点路径代表的字符都不同
>Tire 树代码模板
```python
class Trie(object):
  
	def __init__(self): 
		self.root = {} 
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True
```
##### 并查集 Disjoint Set
跳跃式的数据结构
解决组团和配对的问题

- makeSet(s) 新建一个并查集，其中包含s个单元素集合
- unionSet(x, y) 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
- find(x) 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们
- 各自的代表比较一下就可以了, 进行路径压缩
>并查集代码模板 （java）
```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```
>并查集代码模板 （python）
```python
class UnionFind:

    def init(p): 
        # for i = 0 .. n: p[i] = i; 
        p = [i for i in range(n)] 

    def union(self, p, i, j): 
        p1 = self.parent(p, i) 
        p2 = self.parent(p, j) 
        p[p1] = p2 

    def parent(self, p, i): 
        root = i 
        while p[root] != root: 
            root = p[root] 
        while p[i] != i: # 路径压缩 ?
            x = i; i = p[i]; p[x] = root 
        return root
```

### 第14课 高级搜索

>DFS 代码模板 （递归写法）
```python
class DFSSearch:

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
>DFS 代码模板 （非递归写法）
```python
class DFSSearch:

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

>BFS 代码模板
```python
class BFSSearch:

   def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

>BFS 双向BFS
```python
class BFSSearch:
   def dBFS(graph, start, end):

	beginSet,endSet = {},{};
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```
>A*代码模板
```python
def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)

```
### 第15课 红黑树和AVL树

**树和链表没有本质的区别，从一维空间扩散到二维空间**

二叉搜索树
也称有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）,
是一颗空树或者具有下列性质的二叉树：

**红黑树** 
- 每个结点要么是红色，要么是黑色
- 根结点是黑色
- 每个叶结点是黑色
- 不能有相邻的两个红色结点
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点


**AVL树** -Balance Factor 平衡因子，左子树的高度-右子树的高度

4种旋转操作
- 左旋 右右子树
- 右旋 左左子树
- 左右旋 左右子树
- 右左旋 右左子树

不足：结点需要存储额外信息，且调整次数频繁

>二分查找代码模板
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
		    right = mid - 1
```