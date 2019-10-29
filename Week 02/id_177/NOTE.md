<<<<<<< HEAD
# NOTE

  

=======
# NOTE

##   数据结构

### 哈希表Hash table

- 哈希表（Hash table），也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。
- 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
- 这个映射函数叫作散列函数（Hash function），存放记录的数组叫作哈希表（或散列表）。
    - 关键码值Key value
    - 散列函数Hash function
    - 哈希碰撞Hash Collisions
        - 拉链式解决冲突法
        - 效率退化：O(n)
        
### 映射Map

key-value对，key不重复
    
### 集合Set
    
不重复元素的集合

### 树Tree

- Linked List是特殊化的Tree
- Tree是特殊化的Graph
        
图Graph：树Tree有没有环
    
### 二叉树

**遍历：**

1. 前序（Pre-order）：根-左-右
2. 中序（In-order）：左-根-右
3. 后序（Post-order）：左-右-根
            
### 二叉搜索树
    
有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）
    
**性质：**

1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推：左、右树也分别为二叉查找树。（这就是重复性！）

**中序遍历：升序排列**

## 算法

### 递归Recursion
    
**递归 - 循环**
    
通过函数体来进行的循环
    
1. 从前有个山
2. 山里有个庙
3. 庙里有个和尚讲故事
4. 返回1
    
**盗梦空间**

- 向下进入到不同梦境中；向上又回到原来一层
- 通过声音同步回到上一层
- 每一层的环境和周围的人都是一份拷贝
- 主角等几个人穿越不同层级的梦境（发生和携带变化）
    
**代码模板**

1. recursion terminator 递归终结条件
2. process logic in current level 处理当前层逻辑
3. drill down 下探到下一层
4. reverse the current level status if needed 清理当前层
    
**思维要点**

1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思想

### 分治

**代码模板**

1. recursion terminator
2. prepare data
3. conquer subproblems
4. process and generate the final result
5. revert the current level states
    
### 回溯

## HashMap源码分析

后补


>>>>>>> upstream/master
