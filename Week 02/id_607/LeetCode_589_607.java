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
//递归法：
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        helper(root);
        return res;
    }
    
    private void helper(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            helper(node);
        }
    }
}

