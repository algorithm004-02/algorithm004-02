<<<<<<< HEAD
# NOTE

  

=======
# NOTE
### 第5课 哈希表、映射、集合
写一个关于 HashMap 的小总结
```java
Map: key-value对，key不重复
    - new HashMap() / new TreeMap()
    - map.set(key, value)
    - map.get(key)
    - map.has(key)
    - map.size()
    - map.clear()
    
Set: 不重复元素的集合
    - new HashSet() / new TreeSet()
    - set.add(value)
    - set.delete(value)
    - set.hash(value)
```
>MyHash内部使用items列表来存储数据，items是一个列表，并且每个元素也是一个列表，元素列表中存储了具体的（key,value）元组，不同的key根据hash函数先算出index，即存储在哪条列表中，插入时则直接append，查找时则根据equals方法将待查找的key与列表中的所有元组的第一个值（key）进行比较，找到相等的则返回元组的第二个值（value），找不到则raise KeyError异常。

```python
class MyHash(object):

    def __init__(self, length=10):
        self.length = length
        self.items = [[] for i in range(self.length)]

    def hash(self, key):
        """计算该key在items哪个list中，针对不同类型的key需重新实现"""
        return key % self.length

    def equals(self, key1, key2):
        """比较两个key是否相等，针对不同类型的key需重新实现"""
        return key1 == key2

    def insert(self, key, value):
        index = self.hash(key)
        if self.items[index]:
            for item in self.items[index]:
                if self.equals(key, item[0]):
                    # 添加时若有已存在的key，则先删除再添加（更新value）
                    self.items[index].remove(item)
                    break
        self.items[index].append((key, value))
        return True

    def get(self, key):
        index = self.hash(key)
        if self.items[index]:
            for item in self.items[index]:
                if self.equals(key, item[0]):
                    return item[1]
        # 找不到key，则抛出KeyError异常
        raise KeyError

    def __setitem__(self, key, value):
        """支持以 myhash[1] = 30000 方式添加"""
        return self.insert(key, value)

    def __getitem__(self, key):
        """支持以 myhash[1] 方式读取"""    
        return self.get(key)

myhash = MyHash()
myhash[1] = 30000
myhash.insert(2, 2100)
print myhash.get(1)
myhash.insert(1, 3)
print myhash.get(2)
print myhash.get(1)
print myhash[1]
```

### 第6课 树、二叉树、二叉搜索树
一、树的模板代码Python
```python
class TreeNode:
    def __init__(self,val):
        self.val = val
        self.left,self.right = None,None
       
```
二、树的遍历
1、前序 （根--左--右）
2、中序 （左--右--根）
3、后序 （左--右--根）
模板代码
```python
def preorder:
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

def inorder:
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)
        
def postorder:
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
```
>树的面试题解法一般都是递归，为什么？
首先可以使用递归来解决的问题，一般具有如下特点： 
>1. 该问题可以被分解成若干个重复的子问题； 
>2. 该问题与它分解出的子问题可以使用相同的算法来解决； 
>3. 有明确的终止条件 
>树这种数据结构的特点和上述三个特点高度一致，一棵树的每个非叶子节点的子节点也都是一棵树，都是树自然可以使用相同的算法来处理，
因为没有环所以天然具有终止条件。 另外一方面，树本身是一种非线性的数据结构，循环遍历不易。当然循环遍历也是可以做，树是一种特殊的图，我们完全可以使用图的广度优先遍历算法一层一层的循环遍历整棵树。 综上，我们一般还是选择递归的方式来解决树的问题。
### 第7课 泛型递归、树的递归
```python
def recursion(level,param1,param2,...):
    #recursion terminator
    if level > MAX_LEVEL
    process_result
    return
    
    #process logic in current level
    process(level,data...)
    
    #drill down
    self.recursion(level+1,p1,...)
    
    #reverse the current level status if needed
```
### 第8课 分治、回溯

分治模板代码
```python
def divide_conquer(problem,param1,param2,...):
    #recursion terminator
    if problem is None: 
    process_result
    return
    
    #prepare data 
    data = prepare_data(preblem)
    subproblems = split_problem(problem,data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0],p1,...)
    subresult2 = self.divide_conquer(subproblems[1],p1,...)
    subresult3 = self.divide_conquer(subproblems[2],p1,...)
    ...
    
    # process and generate the final result
    result = process_result(subresult1,subresult2,subresult3,...)
```

>给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

>例如，给出 n = 3，生成结果为：
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

>思路和算法
>只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
>如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
>
```python
class Solution(object):
    def generateParenthesis(self, N):
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * N:
                ans.append(S)
                return
            if left < N:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans
```
  

>>>>>>> upstream/master
