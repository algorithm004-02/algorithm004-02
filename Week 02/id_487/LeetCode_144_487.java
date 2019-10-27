class LeetCode_144_487{
    /***
     *
     * 144题目
     *
     * 给定一个二叉树，返回它的前序 遍历。
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        helperQ(root, integers);
        return integers;
    }

    public void helperQ(TreeNode root, List<Integer> ans) {
        //1结束终止条件
        if (root == null) {
            return;
        }

        // 2.处理当前层逻辑    3。去到下一层
        ans.add(root.val);
        helperQ(root.left, ans);
        helperQ(root.right, ans);

        //4释放当前层数据
    }
}