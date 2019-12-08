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
        LinkedList<Integer> list = new LinkedList();
        if (root == null) {
            return list;
        }
        Deque<Node> deque = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()) {
            Node current = deque.removeFirst();
            list.addLast(current.val);
            for (int r = current.children.size() - 1; r > -1; r--) {
                deque.addFirst(current.children.get(r));
            }
        }
        return list;
    }
}