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
    public List<Integer> preorder(Node root) {
        List<Integer> integers = new ArrayList<>();
        getNodeVal(root, integers);
        return integers;
    }

    private void getNodeVal(Node node, List<Integer> integers) {
        if (node == null) {
            return;
        }
        if (node.children == null) {
            integers.add(node.val);
            return;
        }
        integers.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            getNodeVal(node.children.get(i), integers);
        }


    }
}