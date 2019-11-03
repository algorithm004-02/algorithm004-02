class LeetCode_145_487{
    /***
     *
     * 145题目
     *
     * 给定一个二叉树，返回它的后序 遍历。
     *
     *      * Definition for a binary tree node.
     *      * public class TreeNode {
     *      *     int val;
     *      *     TreeNode left;
     *      *     TreeNode right;
     *      *     TreeNode(int x) { val = x; }
     *      * }
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        helperQ(root, integers);
        return integers;
    }

    public void helperH2(TreeNode root, List<Integer> ans) {
        //1结束终止条件
        if (root == null) {
            return;
        }

        // 2.处理当前层逻辑    3。去到下一层
        helperQ(root.left, ans);
        helperQ(root.right, ans);
        ans.add(root.val);

        //4释放当前层数据
    }
}