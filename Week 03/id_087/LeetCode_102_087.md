# 102. [二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

## BFS

> 广度优先，即层次遍历。时间复杂度O(n)，空间复杂度O(n)。

```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(levelResult);
        }
        return result;
    }
}
```

## DFS

> 深度优先，递归。时间复杂度O(n)，空间复杂度O(n)。

```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        parseNode(root, 0, result);
        return result;
    }

    void parseNode(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (node.left != null) {
            parseNode(node.left, level + 1, result);
        }
        if (node.right != null) {
            parseNode(node.right, level + 1, result);
        }
    }
}
```
