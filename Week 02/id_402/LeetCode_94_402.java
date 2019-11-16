class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LDR(root, list);
        return list;
    }

    private void LDR(TreeNode node, List<Integer> list){
        if (node != null) {
            this.LDR(node.left, list);
            list.add(node.val);
            this.LDR(node.right, list);
        }
    }
}
递归遍历数：
    (输出得前序遍历)
    递归左节点
    (输出得中序遍历)
    递归右节点
    (输出得后序遍历)