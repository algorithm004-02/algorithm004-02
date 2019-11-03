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
/**
    589. N叉树的前序遍历
*/
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        int len = root.children.size();
        for (int i=0; i<len; i++) {
            preorder(root.children.get(i));
        }
        return res;
    }
}