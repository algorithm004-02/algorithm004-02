# 144. [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

## 题目

==示例:==

给定一个二叉树，返回它的 前序 遍历。

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```

## 递归

> 时间复杂度O(n)，空间复杂度平均O(logN)，最坏O(n)

```
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        parseNode(root, result);
        return result;
    }

    void parseNode(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        parseNode(node.left, list);
        parseNode(node.right, list);
    }
}
```

## 迭代

> 时间复杂度O(n)，空间复杂度O(n)

```
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // 前序遍历，是 根左右
            // 入栈时，先入右节点，出栈时，先出的才是左节点
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }
}
```

