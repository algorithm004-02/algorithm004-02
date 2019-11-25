# NOTE

## 	参考链接 
### 14.课高级搜索
* [DFS 代码模板](http://shimo.im/docs/ddgwCccJQKxkrcTq/)
* [BFS 代码模板](http://shimo.im/docs/P8TqKHGKt3ytkYYd/)
* [AlphaZero Explained](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)
* [棋类复杂度](https://en.wikipedia.org/wiki/Game_complexity)
* [A* 代码模板](https://shimo.im/docs/CXvjHyWhpQcxXjcw/)
* [相似度测量方法](https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/)
* [二进制矩阵中的最短路径的 A* 解法](https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python)
* [8 puzzles 解法比较](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)
### 15. 红黑树和AVL树
* [平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

## 代码模板
### A* 代码模板
```
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
### Tire 树代码模板
```
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

### 并查集代码模板
```Java
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
```Python
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

### DFS代码模板
```Python
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
```Python
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

### BFS代码模板
```Python
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

## 实战题目
| Week06 | 第13课 | 字典树和并查集 |
| :---: | --- | --- |
|实战题目|标签 |实现
| [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/) | 字典树 | JavaScript |
| [212. 单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)  | 字典树 | JavaScript |
| [547. 朋友圈](https://leetcode-cn.com/problems/friend-circles/) | 并查集 | JavaScript |
| [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 并查集 | avaScript |
| [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) | 并查集 | JavaScript | 

| Week06 | 第14课 | 高级搜索 |
| :---: | --- | --- |
| [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) | DFS/DP| JavaScript |
| [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | DFS + 回溯 + 减枝 / DP | JavaScript |
| [51. N皇后](https://leetcode-cn.com/problems/n-queens/) | DFS + 回溯 + 减枝 | JavaScript |
| [36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/) | | JavaScript |
| [37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/#/description) | DFS + 减枝\ A* |  JavaScript |
| [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/) | 双向BFS\BFS | JavaScript |
| [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | 双向BFS\BFS | JavaScript |
| [1091. 二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/) | BFS\A* | JavaScript |
| [773. 滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/) | A* | JavaScript |