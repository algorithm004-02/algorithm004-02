/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
//递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        return inorderTraversalHelper(root,list);
    }

    public List<Integer> inorderTraversalHelper(TreeNode root,List<Integer> list) {
        if(root.left!=null){
            inorderTraversalHelper(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversalHelper(root.right,list);
        }
        return list;
    }
}

//迭代
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}