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
    List <Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        
        helper(root);
        return res;
    }
    public void helper(Node root){
        if(root == null) {
            return;
        }
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
        res.add(root.val);
    }
}