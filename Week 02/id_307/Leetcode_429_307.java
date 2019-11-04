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
        List<List<Integer>> levelResults = new ArrayList<>();
        if (root == null) {
            return levelResults;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            int count = deque.size();
            while (count-- > 0) {
                Node current = deque.removeFirst();
                result.add(current.val);                
                for (int i = 0; i < current.children.size(); i++) {
                    deque.addLast(current.children.get(i));
                }
            }
            levelResults.add(result);
        }
        return levelResults;
    }
}