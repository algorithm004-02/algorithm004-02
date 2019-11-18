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
    /**
        590. N叉树的后序遍历
        递归
    */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    
    public void helper(Node node, List res) {
        if (node == null) {
            return;
        }
        
        int s = node.children.size();
        for (int i = 0; i < s; i++) {
            helper(node.children.get(i), res);
        }
        res.add(node.val);
    }
    
}