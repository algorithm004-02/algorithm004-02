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
       List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            while (curr != null) {
                if(curr.right!=null){
                    stack.push(curr);
                }
                res.add(curr.val);
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    break;
                }

            }
            if(!stack.isEmpty()){
                curr = stack.pop().right;
            }
            else {
                break;
            }
        }
        return res; 
    }
}
