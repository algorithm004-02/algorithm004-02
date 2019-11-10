Thinking:
层次遍历二叉树，使用队列

Code:
java
思想1
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
 public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                assert temp != null;
                max = Math.max(max,temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}