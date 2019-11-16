// BFS Method
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (level.size() > 0) {
            List<Integer> cur = new ArrayList();
            List<TreeNode> nex = new ArrayList<TreeNode>();
            for (TreeNode node : level) {
                cur.add(node.val);
                if (node.left != null) {
                    nex.add(node.left);
                }
                if (node.right != null) {
                    nex.add(node.right);
                }
            }
            res.add(cur);
            level = nex;
        }            
        return res;
    }
}