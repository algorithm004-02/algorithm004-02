/* 
* 题号: 94
* 题目: 二叉树的中序遍历
* 地址: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> res) {
        if(root != null){
            if(root.left != null){
                traversal(root.left, res);
            }
            res.add(root.val);
            if(root.right != null){
                traversal(root.right, res);
            }
        }
    } 
}
