## 深度优先搜索
1. DFS代码
```
def dfs(node):
    if node in visited:
        #already visited
        return
    
    visited.add(node)
    
    #process current node
    #...# logic here
    dfs(node.left)
    dfs(node.right)
```

    
2. 深度优先搜索(递归写法)
```
visited = set()
def dfs(node, visited):
    #terminiator
    if node in visited:
        #already visited
        return
    
    visited.add(node)
    
    #process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
```

3. 深度优先搜索(非递归写法)
```
def dfs(self,tree):
    if tree.node is None:
        return []
    
    visited,stack = [],[tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        node = generate_ralted_nodes(node)
        stack.push(nodes)
    
    # other processing work
    ....
```

##广度优先搜索
1. BFS代码
```
def bfs(graph,start,end):
    queue= []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    #other processing work
    ...
```   

2. 递归写法
```
visited = set()
def dfs(node,visited):
    visited.add(node)
    # process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
```

##贪心算法
- 在当前状态最优解
- 不一定是全局最优解

##与动态规划的区别
- TX为每个子问题作出当前最优解,无法回退
- DT会保存以前的运算结果,并根据以前的结果对当前进行选择,有回退功能

##使用贪心算法的注意点:
- 如何确保TX是最优解,即如何确认每个子问题的最优解将是全局最优解
- TX的高效性及其答案比较接近最优解,一般会用来解决对结果要求不特别精确的问题
            
##二分查找的前提
- 目标函数单调性(单调递增/递减)
- 存在上下界(bounded)
- 能够通过索引访问(index accessible)

##二分法代码模板
```
left,right = 0,len(array)-1
while left <= right:
    mid = (left + right)/2
    if array[mid] == target:
        # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```