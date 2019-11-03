# 学习笔记

##  深度优先搜索、广度优先搜索的实现和特性

通常采用的搜索都是通过遍历，通常需要保证每个节点都要访问一次，且仅访问一次。

根据节点访问顺序不同，搜索通常可以分为深度优先搜索和广度优先搜索，其他的还有优先级优先等等。

### 深度优先搜索

如果我们要在一个二叉树中进行深度优先搜索，可以使用递归或栈实现，思路是先访问当前节点，进行数据处理，同时将已访问该节点的记录储存，再依次访问其下的子节点。

### 广度优先搜索

广度优先遍历可以用队列实现， 它的思想是，从起始点开始，由近及远按每一层一次访问节点。

## 贪心的实现、特性及实战题目解析

贪心算法（Greedy）的思想是，在每一步的选择中，都才去当前状态下最好或最优的选择，进而希望导致的结果是全局最好或最优。

贪心算法与动态规划的不同点，在于它对每个子问题的解决方案都进行选择，而且选择之后不能够回退重新选择。而动态规划会保存以前的运行结果，并根据以前的结果，对当前方案进行选择，即有回退功能。

贪心算法可以解决部分最优化问题，如：求图中的最小生成树、哈弗曼编码等等。但局部最优不代表全局最优，这是贪心算法的应用限制。但如果一个方法可以通过贪心算法解决，那么贪心算法一般都是其最优解。

贪心算法可以用作辅助算法，或者直接解决一些对结果要求不十分精确的问题。

## 二分查找的实现、特性及实战题目解析

### 二分查找的前提

1. 目标函数存在单调性（单调递增、递减等），无需的情况只能进行遍历
2. 存在上下边界（bounded），搜索时将收缩区域由边界向最终结果收缩
3. 能够通过索引访问（index accessible）

# 同学代码、总结Review

1. [https://github.com/algorithm004-02/algorithm004-02/issues/561#issuecomment-549113830](https://github.com/algorithm004-02/algorithm004-02/issues/561#issuecomment-549113830)
2. [https://github.com/algorithm004-02/algorithm004-02/issues/565#issuecomment-549113686](https://github.com/algorithm004-02/algorithm004-02/issues/565#issuecomment-549113686)
3. [https://github.com/algorithm004-02/algorithm004-02/issues/550#issuecomment-549114103](https://github.com/algorithm004-02/algorithm004-02/issues/550#issuecomment-549114103)
4. [https://github.com/algorithm004-02/algorithm004-02/issues/551#issuecomment-549114175](https://github.com/algorithm004-02/algorithm004-02/issues/551#issuecomment-549114175)
5. [https://github.com/algorithm004-02/algorithm004-02/issues/548#issuecomment-549114286](https://github.com/algorithm004-02/algorithm004-02/issues/548#issuecomment-549114286)
