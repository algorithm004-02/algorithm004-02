class Solution {
        //左根右
    List<Integer> res = new ArrayList<> ();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {//或者的关系
            while (cur != null) {
                stack.push(cur);//确保每次有push操作
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    
}