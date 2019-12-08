# Trie - 字典树

## 基本性质
1. 节点本身不存完整的单词
2. 从根结点开始，经过路径上的所有边，连接起来的结点就是最后的内容
3. 每个结点的所有子路径结点都不相同。

## 处理模式：
把存储的内容，细分之后，不在存没个完整的内容，而是字母之类。
为了减少无畏的搜索和查询。

## 场景：
1. 词频统计

## 应用
可以把大的内容，细分之后存储，加快搜索速度。

## Trie模板： Python
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
