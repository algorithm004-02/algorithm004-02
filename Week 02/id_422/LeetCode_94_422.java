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

        List<Integer> result = new LinkedList();

        //recursion(root,result);
        iteration(root,result);
        return result;

    }

    void recursion(TreeNode root,List<Integer> result){

        if(root == null) return;

        recursion(root.left,result);
        result.add(root.val);
        recursion(root.right,result);

    }

    void iteration(TreeNode root,List<Integer> result){

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;


        while(cur != null || !stack.isEmpty()){

            //执行完 最左节点已经在栈顶了
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //直接取出来就是最左节点
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;

        }
    }
}