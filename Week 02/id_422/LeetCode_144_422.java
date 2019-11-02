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
    List<Integer> list = new ArrayList();
    
    public List<Integer> preorderTraversal(TreeNode root) {
   
        //结束条件
        if(root == null){
            return list;
        }
        
        list.add(root.val);
        
		TreeNode leftTree = root.left;
		if(leftTree != null)
		{
			preorderTraversal(leftTree);
		}
        
		TreeNode rightTree = root.right;
		if(rightTree != null)
		{
			preorderTraversal(rightTree);
		}
        
        return list;
    }
}