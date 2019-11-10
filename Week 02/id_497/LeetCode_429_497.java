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
        List<List<Integer>> integers = new ArrayList<>();

        getNodeVal(root, integers, 0);

        return integers;
    }

    private void getNodeVal(Node node, List<List<Integer>> integers, Integer level) {

        if (node == null) {
            return;
        }
        if (node.children == null) {
            integers.get(level).add(node.val);
            return;
        }

        if (integers.size() < level + 1) {
            integers.add(new ArrayList<Integer>());
        }
        integers.get(level).add(node.val);
        level++;
        for (int i = 0; i < node.children.size(); i++) {
            getNodeVal(node.children.get(i), integers, level);
        }

    }
}