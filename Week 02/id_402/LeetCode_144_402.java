class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        DLR(root, list);
        return list;
    }

    private void DLR (TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            this.DLR(node.left, list);
            this.DLR(node.right, list);
        }
    }
}