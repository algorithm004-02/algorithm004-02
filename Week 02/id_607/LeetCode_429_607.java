class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return list;
        helper(root, 0, list);
        return list;
    }
    
    //需要记录深度
    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        //判断是否新的一层,new一个list
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        //取出当前层list，添加当前节点
        res.get(depth).add(root.val);

        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }
    
}