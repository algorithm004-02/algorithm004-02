/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */


//递归
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        return inorderTraversalHelper(root,list);
    }

    public List<Integer> inorderTraversalHelper(TreeNode root,List<Integer> list) {
        list.add(root.val);
        if(root.left!=null){
            inorderTraversalHelper(root.left,list);
        }
        if(root.right!=null){
            inorderTraversalHelper(root.right,list);
        }
        return list;
    }
}

//迭代
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return list;
    }
}