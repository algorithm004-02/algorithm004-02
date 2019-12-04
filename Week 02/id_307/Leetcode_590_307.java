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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            Node current = deque.removeFirst();
            result.addFirst(current.val);
            for (int i = 0; i < current.children.size(); i++) {
                deque.addFirst(current.children.get(i));
            }
        }
        return result;
    }
}