# 树的遍历

## 递归

```
visited = set()

def dfs(node, visited):
if node in visited: # terminator 一开始递归的终止条件
	# already visited 已经访问过
	return

	visited.add(node) 处理当前层

	# process current node here.
	...
	for next_node in node.children():
		if not next_node in visited: //判断 下一个节点是否被访问过
			dfs(next_node, visited)
```

## 层序

```
def BFS(graph, start, end):

	queue = []
	queue.append([start])
	visited.add(start)

	while queue:
		node = queue.pop()
		visited.add(node)

		process(node)
		nodes = generate_related_nodes(node)
		queue.push(nodes)

	# other processing work
	...
```

# 贪心算法

1. 希望达到最终最优，每步都选择当前最优
2. 性能好，适合特定问题或者辅助算法
3. 贪心对每个子问题选择最优解，且不回退，也不保存中间状态
4. 需要证明贪心是 OK 的

# 二分查找

1. 单调性
2. 存在上下界
3. 通过索引访问

## 二分代码模板

```
left, right := 0, len(nums)-1
for left <= right {
    mid := left + (right - left) / 2
    if nums[mid] == target {
        return mid
    } else if nums[mid] > target {
        right = mid - 1
    } else{
        left = mid + 1
    }
}
```
