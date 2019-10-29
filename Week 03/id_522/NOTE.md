# NOTE

2019-10-28 开始看深度优先和广度优先，这个比较容易


```
#递归写法
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


#非递归写法
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
而后看贪心，再是二分查找，看了两遍。
1、单调性
2、上下界
3、可以通过索引查找。

对于代码模板，默写如下： python 3 。
```
class Solution:

    def binsearch(self, lista, target):

        left, right = 0, len(lista) - 1
        while left < right:
            mid = (left + right ) >> 1    # +1  ,是否加一，看情况

            if target == lista[mid]:
                return mid
            elif target > lista[mid]:
                left = mid+1  # +1  ,不加，因为while 没有用=
            else:
                right = mid
        return False


cc = Solution()
lista = [k for k in range(9)]
target = 9
print(cc.binsearch(lista, target))

```

2019-10-29
先准备写433 题，发现看不懂题目，就看127 题，感觉双向BFS ，难度较大，先写一个单向的，费了3个多小时。
而后看懂了双向的，官网的写法，
又一次，被敲脑袋，defaultdict ，基础的数据结构，很有用。

做不出来，题目，不爽，把22题，515 题，一顿暴打，哈哈，打不过老虎，我踢猫。
