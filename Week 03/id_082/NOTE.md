# 学习总结
### 深度优先和广度优先搜素
根据节点访问顺序的不同，分为深度优先搜索和广度优先搜索，需要注意的是不重复的遍历所有节点
深度优先遍历模板
```
visited = set()
def dfs(node, visited) {
    if node in visited: #terminator
        # already visited

    visited.add(node)

    # process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
}
```
广度优先遍历模板
```
visited = set()
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    while(queue):
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(queue)
```
### 贪心算法（Greedy）
一种在每一步的选择中选择当下最好的选择，从而希望导致结果是全局最好或最优的算法。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退，
动态规划会保存以前的运算结果，并根据以前的运算结果对当前进行选择，有回退功能。

贪心算法用在解决一些最优化的问题。前提是这些问题是能分解成子问题解决，子问题的最优解的组合得到最后的最优解。

### 二分查找
最关键的三个前提条件
1. 目标函数单调性
2. 存在上下界
3. 能够通过索引访问
代码模板
```
left, right = 0, len(arry) -1
while left <  right
    mid = (left + right)/2
    if array[mid] == target:
        # find the target!
        break or return result
    elif array[mid] < target:
        left = mid+1
    else:
        right = mid-1
```
### 寻找旋转数组的有序部分
一个升序数组在某个未知的点进行旋转，从总体上已经是无序的了，但是供 0 到 len-1 中至少有一半是有序的，
另一半按原始的最大值，一部分升序、一部分降序。
如果原来的有序数组 a1, a2, a3, .... an。旋转后以 an 为临界点点，an 左边部分为升序，右边部分为降序。

