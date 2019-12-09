// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
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
//
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        helper(root, result);
        return result;
    }
    private void helper(Node root, List res) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(child);
        }
        res.add(root.val);
    }
}
// 使用栈
// todo: 有错误
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        Stack<Node> stack = new Stack();
        Node curr = root;
        if (curr == null) return res;
        stack.push(curr);
        
        while (!stack.isEmpty()) {
            if (curr.children.isEmpty()) {
                res.add(curr);
                curr = stack.pop();
                continue;
            }
            while (!curr.children.isEmpty()) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    if (curr.children.get(i) != null) {
                        stack.push(curr.children.get(i));
                    }
                }
                curr = stack.peek();
            }
            if (curr.children.isEmpty()) {
                curr = stack.pop();
            }
        }
        return res;
    }
}