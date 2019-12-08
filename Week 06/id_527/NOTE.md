# 关于双向BFS的思考

双向广度优先算法相对于广度优先算法来说，由于采用了从两个跟开始扩展的方式，搜索树的深度得到了明显的减少，所以在算法的时间复杂度和空间复杂度上都有较大的优势。双向广度优先算法特别适合于给出了起始节点和目的节点，要求他们之间的最短路径的问题（一个从起点扩展，一个从终点扩展）。另外需要说明的是，广度优先的顺序能够保证找到的路径就是最短路径！

具体模板代码可参考 [LeetCode 127. Word Ladder](https://leetcode.com/problems/word-ladder/) 下的 [该解答](https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms./390510/) 。

# NOTE

## Trie 树

> 字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。经常被搜索引擎系统用于文本词频统计。

- 典型应用

    统计和排序大量的字符串（但不仅限于字符串）。

- 优点

    最大限度地减少无谓的字符串比较，查询效率比哈希表高。

- 基本性质

    1. 结点本身不存完整单词
    
    2. 从根节点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串

    3. 每个结点的所有子结点路径代表的字符都不相同

- 核心思想

    > 空间换时间

    利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### Trie 树代码模板

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

## 并查集（Disjoint Set）

- 基本操作

    - `makeSet(s)`：建立一个新的并查集，其中包含 `s` 个单元素集合。

    - `unionSet(x, y)`：把元素 `x` 和元素 `y` 所在的集合合并，要求 `x` 和 `y` 所在的集合不相交，如果相交则不合并。

    - `find(x)`：找到元素 `x` 所在的集合的代表，该操作也可以用于判断两个原色是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

### 并查集代码模板

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
            // 路径压缩
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

## 初级搜索

1. 朴素搜索

2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）

3. 搜索方向：DFS、BFS、双向搜索、启发式搜索

### DFS 代码模板

#### 递归写法

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

#### 非递归写法

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

### BFS 代码模板

```python
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

## 启发式搜索 Heuristic Search (A*)

### 估价函数

启发式函数：h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n)会返回一个非负实数，也可以认为式从结点n的目标结点路径的估计成本。

启发式函数式一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。

### A* 代码模板

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

## AVL 树

> 通过旋转操作来进行平衡

### 平衡因子
> 左子树和右子树的高度差最大为 `1` 。

### 旋转操作

- 右右子树：左旋

- 左左子树：右旋

- 左右子树：左右旋

- 右左子树：右左旋

### 红黑树

> 近似平衡的二叉搜索树，能确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树式满足如下条件的二叉搜索树：

- 每个结点要么式黑色，要么是红色

- 根节点是黑色

- 每个叶结点（NIL结点、空结点）是黑色

- 不能右相邻接的两个红色结点

- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点

