/**
 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 /
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

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        levelOrder(root,result,0);
        return result;
    }

    private void levelOrder(Node root, List<List<Integer>> result, int level) {
        if (result.size() <= level) {
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            result.add(levelList);
        }
        result.get(level).add(root.val);

        if (root.children != null) {
            for (Node node : root.children) {
                levelOrder(node,result,level+1);
            }
        }
    }
}