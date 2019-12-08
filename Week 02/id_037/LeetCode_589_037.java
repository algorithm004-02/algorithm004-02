// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
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
// 递归
class Solution {
    private List<Integer> res = new ArrayList();
    public List<Integer> preorder(Node root) {
        if (root = null) return res;
        Stack<Node> stack = new Stack();
        Node curr = root;
        res.add(curr.val);
        for (int i = 0; i < curr.children.size(); i++) {
            preorder(curr.children.get(i));
        }
    }
}