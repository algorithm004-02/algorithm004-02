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
        List<List<Integer>> levels = new ArrayList();

        if(root ==null) return levels;

        helper(root,levels,0);

        return levels;
    }



    public void helper(TreeNode node,List<List<Integer>> levels, int level) {
        //当前层
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        //记录当前层的节点值
        levels.get(level).add(node.val);

        //下一级的子节点
        if (node.left != null)
            helper(node.left, levels ,level + 1);
        if (node.right != null)
            helper(node.right, levels ,level + 1);
    }
}
