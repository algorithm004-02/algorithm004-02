class LeetCode_104_487{
    /***
     *
     * 104题
     *
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        //1终止条件
//        if (root == null) {
//            return 0;
//        }
//        //2处理当前层   3下到下一层
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//        return Math.max(leftDepth, rightDepth) + 1;

        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}