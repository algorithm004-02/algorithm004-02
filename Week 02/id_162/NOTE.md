# NOTE

##树

####树的通用代码
```java
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```


####为什么树一般使用递归？
1. 树节点的定义就是使用递归进行的。
2. 树、搜索二叉树等数据结构，有重复性（自相似性）的性质包含其中。（eg：xxx,且左右子树也有相同特点）

####二叉搜索树：
1. 有序
2. 左子树所有节点值 < 根节点的值 < 右子树所有节点值
3. 左、右子树也是二叉排序树。
4. 中序遍历后是升序排列

**复杂度：**
1. 插入：LogN
2. 查询：LogN
3. 删除：LogN

**操作：**
查询：二分
插入：二分
删除：二分
    - 叶子节点：直接删除。
    - 非叶子节点：删除，拿右子树最小的节点（值最相近）替换上去。

##递归
####1. 递归代码模板
```javapublic void recur(int level, int param) {    
    // 1.terminator 退出机制
    if (level > MAX_LEVEL) {
        // process result
        return; 
    }
    
    // 2.process current logic 当前层逻辑
    process(level, param);
    
    // 3.drill down 下探到下一层
    recur( level: level + 1, newParam);
    
    // restore current status 整理状态
}
```
####2. 递归思维要点
1. 不要人肉递归，直接看函数本身开始写即可。
2. 找到最近最简方法，将其拆解为可重复解决的问题。
    1. 我们程序只包含if-else、while、递归
3. 数学归纳法思维
    1. n=1,2 正确
    2. n=N的时候成立，可以证明n=N+1的时候成立。

####3. 递归效率低下吗？
不正确。
递归本身并不存在效率差、效率低的问题。只要程序本身算法复杂度没有写残即可。
举个例子：斐波那契数列，若只是傻傻递归，但是没有把中间结果存储起来，导致本身线性能解决的问题，需要指数级时间复杂度才能解决的话，是不合理的。但是锅本身不在递归上边，而是程序写残了。
写傻的原因，是可能是对递归的状态书不熟悉，造成没有使用缓存优化。

####4. 递归是不是一定就比非递归慢一些？
递归慢的原因是它需要开一些栈，如果递归深度很深的话，的确可能有这样的问题。
一般而言，现代计算机的存储方式、编译器对于递归、尾递归都有一定的优化，可以直接认为递归和循环效率是一样的。


##分治
####1. 分治代码模板
```python
def divide_conquer(problem, param1, param2, ...):  # 1.recursion terminator  if problem is None:    print_result    return  
  # 2.prepare data  data = prepare_data(problem)  subproblems = split_problem(problem, data)  
  # 3.conquer subproblems  subresult1 = self.divide_conquer(subproblems[0], p1, ...)  subresult2 = self.divide_conquer(subproblems[1], p1, ...)  subresult3 = self.divide_conquer(subproblems[2], p1, ...)  ...  
  # 4.process and generate the final result  result = process_result(subresult1, subresult2, subresult3, ...)  
  # 5.revert the current level states
```
