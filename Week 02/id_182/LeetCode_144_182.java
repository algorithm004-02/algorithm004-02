/* 
* 题号: 144
* 题目: 二叉树的前序遍历
* 地址: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
*/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
    public void traversal (TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            if(root.left != null){
                traversal(root.left, res);
            }
            if(root.right != null){
                traversal(root.right, res);
            }
        }
        
    }
}
