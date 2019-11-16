/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> PreorderTraversal(TreeNode root) {
        var result=new List<int>();
        if(root==null) return result;
        AddNode(result,root);
        return result;
    }
    
    private void AddNode(List<int> result,TreeNode node)
    {
        result.Add(node.val);
        if(node.left!=null) AddNode(result,node.left);
        if(node.right!=null) AddNode(result,node.right);
    }
}