<h1> 【402-Week 06】 学习总结</h1>
<h1> Trie（字典树）树</h1>
<h2>基本结构</h2>

字典树，及Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。<br>

优点：最大限度的减少无谓的字符串比较，查询效率比哈希表高。<br>

<h2>基本性质</h2>

1. 几点本身不存完整单词。
2. 从根结点到某一结点，路径上经过的字符连接起来，为该节点对应的字符串。
3. 每个结点的所有子结点路径代表的字符都不相同。

<h2>核心思想</h2>

1. Trie书的核心思想空间换时间。
2. 李勇字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。		

<h2>代码模板</h2>

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



<h1>并查集</h1>
<h2>适用场景</h2>

- 组团、配对问题
- Group or not ？

<h2>基本操作</h2>

- makeSet（s）：建立一个新的并查集，其中包含s个单元集合。
- unionSet（x，y）：把元素x和元素y所在的集合合并，要求x和y所在的集合不想交，如何相交则不合并。
- find（x）：找到元素x所在的集合的代表，操作也可以用于判断两个元素是否位于同一个集合，只要它们各自的代表比较一下就可以了。





<h2>模板代码</h2>

```java
//java
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

