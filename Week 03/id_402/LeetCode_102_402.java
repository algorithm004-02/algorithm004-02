Thinking:
1/使用BFS遍历模板，使用队列来进行维护。
2/递归 判断查找

Code:

java
思路1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        }
        while (!nodeQueue.isEmpty()) {
            int count = nodeQueue.size();
            List<Integer> varList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode temp = nodeQueue.poll();
                assert temp != null;
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                }
                varList.add(temp.val);
            }
            list.add(varList);
        }
        return list;
    }
}


思路2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root,  0,  list);
        return list;
    }

    private void recursion(TreeNode node, int depth, List<List<Integer>> list) {
        if (node == null) {
            return;
        }

        if (list.size() < depth + 1) {
            list.add(new ArrayList<>());
        }

        list.get(depth++).add(node.val);
        recursion(node.left,  depth,  list);
        recursion(node.right,  depth,  list);
    }
}

