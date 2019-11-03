# 94. [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

## 题目

给定一个二叉树，返回它的中序 遍历。

==示例:==

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```

## 递归

> 时间复杂度O(n)，空间复杂度O(logN)，最坏情况为O(n)

```
class Solution {
    // 1. 递归
    // 2. 循环
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        parseNode(root, result);
        return result;
    }

    void parseNode(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        parseNode(node.left, list);
        list.add(node.val);
        parseNode(node.right, list);
    }
}
```

## 迭代

> 时间复杂度O(n)，空间复杂度O(n)

```
class Solution {
    // 1. 递归
    // 2. 循环
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.add(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            result.add(curNode.val);
            curNode = curNode.right;
        }
        return result;
    }
}
```

