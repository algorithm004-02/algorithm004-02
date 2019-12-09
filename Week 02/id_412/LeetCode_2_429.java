import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
     public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    helper(root, 0, res);
    return res;
}

private void helper(Node root, int depth, List<List<Integer>> res) {
    if (root == null) return;
    //判断是否是新的一层
    if (depth + 1 > res.size()) {
        res.add(new ArrayList<>());
    }
    res.get(depth).add(root.val);

    //处理子节点
    for (Node node : root.children) {
        if (node != null) {
            helper(node, depth + 1, res);
        }
    }
}

}
