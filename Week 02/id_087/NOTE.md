# NOTE

通过这周的学习，对二叉树及递归有了些理解。尤其是通过代码实践，加强了理解。

## 做题

1. 用不同思路，解决问题，加强理解
2. 分析时间、空间复杂度

## 树的结构

==python==

```
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
```

==Java==

```
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

## 树的遍历模板

```
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
def inorder(self, root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)
def postorder(self, root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
```

## 递归代码模板

本周特别需要记录的是，递归代码模板

```
// 1. 终止条件

// 2. 逻辑处理

// 3. 进入下一层递归

// 4. 清理数据
```

## 分治代码模板

> divide conquer，分治回溯和一般递归相比，多了一步，在清理数据前，可能需要对结果进行进一步的加工整理。

```
// 1. 终止条件，处理结果

// 2. 逻辑处理

// 3. 进入下一层递归

// 4. 组合结果

// 5. 清理数据
```
