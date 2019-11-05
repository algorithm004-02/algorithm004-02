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
    
    public List<List<Integer>> level_order = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null) {
            return level_order;
        }
        
      
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> current_level = new ArrayList<>();
                
           for (int i =0; i < size; i++) {
                
                TreeNode current = queue.poll();
                current_level.add(current.val);
                
                if (current.left != null ) {
                    queue.offer(current.left);
                }
                
                if (current.left != null) {
                    queue.offer(current.right);
                }
               
                
            }
            
           level_order.add(current_level);
        }
        
        return level_order;
        
    
    }
    
    public void helper (TreeNode node, Integer level) {
        if (level_order.size() == level) {
            level_order.add(new ArrayList());
        }
        
        level_order.get(level).add(node.val);
        
        if (node.left != null ){
            helper(node.left, level + 1);
            
        }
        
        if (node.right != null) {
            helper(node.right, level+1);
        }
    }
}