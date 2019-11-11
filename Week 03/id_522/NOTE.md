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

10-30 早上起来，就写33题，自己没有写出来，二分，二分，二分，
看了官方的题解，先是用两遍二分的，第一遍就是找到旋转点。而后把数组，按照旋转点，切为两部分，看看，target 在哪一部分，就在哪一部分里面找。
感觉挺好，但是，需要处理下标问题。

看到这个人讲的，感觉好多了，一遍就行了。
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-35/
解法三
参考这里，算法基于一个事实，数组从任意位置劈开后，至少有一半是有序的，什么意思呢？

比如 [ 4 5 6 7 1 2 3] ，从 7 劈开，左边是 [ 4 5 6 7] 右边是 [ 7 1 2 3]，左边是有序的。

基于这个事实。

我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。

作者：windliang

```

public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == nums[mid]) {
				return mid;
			}
            //左半段是有序的
			if (nums[start] <= nums[mid]) {
                //target 在这段里
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
            //右半段是有序的
			} else {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}
		return -1;
	}


```
这里面最关键的是，= 号，一旦漏了一个，程序立马错了，真的要非常小心。

我的代码

```
class Solution:
    def search(self, nums: List[int], target: int) -> int:

        left , right= 0 , len(nums)-1

        while left <= right:  #这里的= 很重要

            mid =left+right>>1
            if nums[mid] == target :
                return mid

            #假设左边是升序的
            if nums[left]<=nums[mid]:
                if  nums[left] <= target <nums[mid]:  #这里的= 不可能 target <=nums[mid]
                    right=mid-1
                else:
                    left=mid+1
            else: #此时右边是升序的
                if nums[mid] < target <=nums[right]:
                    left=mid+1
                else:
                    right=mid-1
        return -1
```
这里还有一个心得，就是，只关注好写的业务逻辑，其他的用else 搞定，如 nums[mid] < target <=nums[right]


在这里，把455 题的收获，写下来，

# 第一遍 ，用了deque ，不断的 popleft() ，以为 这个性能比列表好；

#看了官方的题解，应该移动下标，，顿时，感觉自己很蠢。

#第三遍，看了官方题解后。这里有个问题？？？

#马上找到 python idle 测试了，

'''
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
2.240844687
>>>
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
2.317422119
>>>

# while i< len(g) and j<len(s) 用时，在下面，明显变长了。
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
3.233211371
>>>
=================== RESTART: G:/Python/Python37/zhongxu.py ===================
3.2318194929999997

'''

```
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        g.sort()
        s.sort()
        res=0
        i,j =0,0

        qqq=len(g)
        ttt=len(s)
        while i<qqq and j<ttt :
       # while i< len(g) and j<len(s) :  #这里，每次执行while ，都会再执行一遍len 函数调用么？ 用时较多

            if s[j] >= g[i]:
                i+=1
                j+=1
                res+=1
            else:

                j+=1
        return res

```
11-1 继续看二分
#看了国际站后，服了。

class Solution:

    def binsearch(self, nums, target):
        size = len(nums)
        left, right = 0, size - 1
        # find the min
        while left < right :
            mid = left + right >> 1

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid

        mmin = left

        left, right = 0, size - 1  #  ，must do it again
        while left <= right:    #这里的= ，必须的，我忘记了。
            mid = left + right >> 1
            real = (mid + mmin) % size   #魔法，漂亮

            if nums[real] == target: return real
            if nums[real] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1
