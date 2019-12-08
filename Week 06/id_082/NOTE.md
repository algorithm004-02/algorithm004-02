## 字典树和并查集
### 字典树 Trie
#### 字典树的数据结构
Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），
所以经常被搜索引擎系统用于文本词频统计。
它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
#### 字典树的核心思想
- Trie 树的核心思想是空间换时间
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
#### 字典树的基本性质
- 结点本身不存完整单词
- 从根结点到某一结点，路径上经过的字符串连接起来，为该结点对应的字符串
- 每个结点的所有子结点路径代表的字符都不同

### 并查集 Disjoint Set
跳跃式的数据结构
组团和配对的问题
- makeSet(s) 新建一个并查集，其中包含s个单元素集合
- unionSet(x, y) 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
- find(x) 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们
  各自的代表比较一下就可以了, 进行路径压缩
```
def init(p):
  #for i = 0..n: p[i]=i;
  p = [i for i range(n)]
  
def union(self, i, j):
  p1 = self.parent(p, i)
  p2 = self.parent(p, j)
  p[p1] = p2

def parent(self, p, i):
  root = i
  while p[root] != root:
    roor = p[root]
  while p[i] != i: # 路径压缩
    x=i;i=p[i];p[x]=root
  return root
```

回溯
尝试采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，
当它通过尝试发现现有的分步答案不能得到有效的结果的正确的解答的时候，它将
取消上一步甚至几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。

启发式搜索
```
def AstarSearch(graph, start, end) {
  # 优先级、估价函数
  pq = collections.priority_queue()
  pq.append([start])
  visited.add(start)
  
  while pq:
    node = pq.pop() 
    visited.add(node)
    
    process(node)
    nodes = generate_related_nodes(node)
    unvisited = [node for node in nodes if node not in visited]
      pq.push(unvisited)
}
```
估价函数：
启发式函数 h(n) 它用来评价那些结点最优希望成为要找到的结点

### 红黑树和AVL树
树和链表没有本质的区别，从一维空间扩散到二维空间

树 Tree  重复定义
二叉树 Binary Tree
遍历 
  前序 Pre-order (根左右) 
  中序 In-order (左根右)
  后序 Post-order (左右根)
二叉搜索树
也称有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）,
是一颗空树或者具有下列性质的二叉树：
1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推，左、右子树也分别为二叉查找树。 （这就是重复性）
中序遍历：升序排列
```
def preorder(self, root):
  if root:
    self.traverse_path.append(root.val)
    self.preorder(root.left)
    self.preorder(root.right)

def inorder(self, root):
  if root:
    self.inorder(root.left)
    self.traverse_path.append(root.val)
    self.inorder(root.right)

def postorder(self, root):
  if root:
    self.postorder(self, root.left)
    self.postorder(self, root.right)
    self.traverse_path.append(root.val)
```
平衡二叉树 Balanced

1. AVL 树 
  Balance Factor 平衡因子，左子树的高度-右子树的高度
  旋转操作
  记录左右子树高度
4种旋转操作
- 左旋  右右子树
- 右旋  左左子树
- 左右旋  左右子树
- 右左旋  右左子树

不足：结点需要存储额外信息，且调整次数频繁

2. 红黑树
  近似平衡二叉树，它能确保任何一个结点的左右子树的高度差小于两倍。
- 每个结点要么是红色，要么是黑色
- 根结点是黑色
- 每个叶结点是黑色
- 不能有相邻的两个红色结点
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
3. 2-3 树
4. B-Tree 