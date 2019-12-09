class LeetCode_94_487{
    /***
     *
     * 94题目
     *
     * 给定一个二叉树，返回它的中序 遍历。
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        helperZ(root, integers);
        return integers;
    }

    public void helperZ(TreeNode root, List<Integer> ans) {
        //1结束终止条件
        if (root == null) {
            return;
        }

        // 2.处理当前层逻辑    3。去到下一层
        helperZ(root.left, ans);
        ans.add(root.val);
        helperZ(root.right, ans);

        //4释放当前层数据


//        //其他：假如是前序遍历
//        ans.add(root.val);
//        helperZ(root.left, ans);
//        helperZ(root.right, ans);
//
//        //其他：假如是后续遍历
//        helperZ(root.left, ans);
//        helperZ(root.right, ans);
//        ans.add(root.val);
    }
}