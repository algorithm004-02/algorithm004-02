# 第三周学习总结

## 第9课 | 深度优先搜索和广度优先搜索
### 深度优先搜索

#### DFS代码模板

##### 递归写法
```python
  visited = set();
  def dfs(node):
    if node in visited
      # already visited
      return
    
    # process current node
    # ... # logic here
    dfs(node.left)
    dfs(node.right)
````

```python
    visited = set();

    def dfs(node, visited):
    if node in visited #terminator
      # already visited
      return
    
    # process current node here
    ...
    for next_node in node.children()
      if not next_node in visited:
        dfs(next_node, visited)
```

##### 非递归写法
```python
    def DFS(self, tree):
      if (tree.root is None):
        return []
    
        visited, stack = [], [tree.root]

        while stack:
            node = stack.pop()
            visited.add(tree)

            process(node)
            nodes = generate_related_nodes(nodes)
            stack.push(nodes)

    # other processing work
```

### BFS代码模板
```python
    def BFS(graph, start, end):
      
        queue = [];
        queue.append([start])
        visited.add(start)

        while queue:
            node = queue.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            queue.push(node)
```


### 搜索遍历
- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
  - 深度优先： depth first search
  - 广度优先： breadth first search
  
## 第10课 | 贪心算法
### 贪心算法
> 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择， 从而希望导致结果是全局最好或最优的算法

> 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果， 并根据以前的结果对当前进行选择，有回退功能

> 贪心算法可以解决一些最优化问题， 如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题， 贪心法一般不能得到我们所要求的答案。

> 一旦一个问题可以通过贪心法来解决， 那么贪心一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求不特别精确的问题。

- [动态规划定义](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)

## 第11课 | 二分查找

### 二分查找的前提
- 1.目标函数的单调性(单调递增或单调递减)
- 2.存在上下界（bounded)
- 3.能够通过索引访问(index accessible)
  
### 代码模板
```python
  left, right = 0, len(array) - 1
  while left <= right :
    mid = (left + right) / 2
    if array[mid] === target:
      # find the target
      break or return result
    else if array[mid] < target:
      left = mid + 1
    else 
      right = mid - 1
```

## 实战题目
| Week03 | 第9课 | 深度优先与广度优先 |
| :---: | --- | --- |
| 实战题目 | 标签 | 实现 |
| [102.二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description) | [树](https://leetcode-cn.com/tag/tree/) | javaScript |
| [433.最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description) | | javaScript |
| [22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description) | | javaScript |
| [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description) | | javaScript |
| Homework | 标签 | 实现 |
| [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/description/) | | javaScript | 
| [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/description/) |  | javaScript |
| [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) |  | javaScript |
| [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/) | | javaScript |

| Week03 | 第10课 | 贪心算法 |
| :---: | --- | --- |
| Homework| 标签 | 实现 |
| [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) | | javaScript |
| [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/) | | javaScript |
| [455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/) | | javaScript |
| [874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/) | | javaScript |
| [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/) | | javaScript |
| [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/) | | javaScript |
| [（参考）322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) | | javaScript |

| Week03 | 第10课 | 贪心算法 |
| :---: | --- | --- |
| 实战题目 | 标签 | 实现 |
| [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/) | | javaScript |
| [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/) | | javaScript |
| Homework| 标签 | 实现 |
| [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | | javaScript |
| [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) | | javaScript |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | | javaScript |