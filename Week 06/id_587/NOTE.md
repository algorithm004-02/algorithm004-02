# 学习笔记

## 字典树和并查集

### Trie 树的基本实现和特性

#### Trie 树的基本概念

字典树，即 Trie 树，又被称作单词查找树或键树，是一种树形结构。

主要应用在统计和排序大量的字符串（并不仅限于字符串），因此经常被搜索引擎系统用于文本词频统计等。

其优点是，能够最大限度减少无谓的字符串比较，查询效率高于哈希表。

#### Trie 树的基本的特点

1. 结点本身不存完整单词，只存储一个字符。
2. 从根结点到某一结点，经过的每个节点存储的字符连接起来，为该结点对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同。

#### Trie 树的核心思想

1. 以空间换时间。
2. 以输入字母作为公共前缀，通过 Trie 树将其下游的字母查找出来，即形成了提示单词。以达到加快查询的目的。

## AVL 树和红黑树的实现和特性

### AVL 树

1. 发明者 G. M. Adelson-Velsky 和 Evgenii Landis
2. Balance Factor（平衡因子）：
   是它的左子树的高度减去它的右子树的高度（有时相反）。
   balance factor = {-1, 0, 1}
3. 通过旋转操作来进行平衡：左旋、右旋、左右旋、右左旋。
4. In computer science, a self-balancing (or height-balanced) binary search tree is any node-based binary search tree that automatically keeps its height (maximal number of levels below the root) small in the face of arbitrary item insertions and deletions.

### 红黑树

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树。

它有以下定义：

1. 每个结点要么是红色，要么是黑色
2. 根节点是黑色
3. 每个叶节点（NIL 节点，空节点）是黑色的。
4. 不能有相邻接的两个红色节点
5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

# 同学代码、总结 Review

1. [https://github.com/algorithm004-02/algorithm004-02/issues/944#issuecomment-557883820](https://github.com/algorithm004-02/algorithm004-02/issues/944#issuecomment-557883820)
2. [https://github.com/algorithm004-02/algorithm004-02/issues/941#issuecomment-557883935](https://github.com/algorithm004-02/algorithm004-02/issues/941#issuecomment-557883935)
3. [https://github.com/algorithm004-02/algorithm004-02/issues/938#issuecomment-557884292](https://github.com/algorithm004-02/algorithm004-02/issues/938#issuecomment-557884292)
4. [https://github.com/algorithm004-02/algorithm004-02/issues/933#issuecomment-557884483](https://github.com/algorithm004-02/algorithm004-02/issues/933#issuecomment-557884483)
5. [https://github.com/algorithm004-02/algorithm004-02/issues/931#issuecomment-557884601](https://github.com/algorithm004-02/algorithm004-02/issues/931#issuecomment-557884601)
