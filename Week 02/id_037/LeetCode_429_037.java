import java.util.LinkedList;

// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
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
        List<List> res = new ArrayList();
        if (root == null) return new ArrayList(hash.values());
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            List tempList = new ArrayList();
            while (count-- > 0) {
                Node curr = queue.remove();
                tempList.add(curr.val);
                for (int i = 0; i < curr.children.size(); i++) {
                    if (curr.children.get(i) != null) queue.add(curr.children.get(i));
                }
            }
            res.add(tempList);
        }
        return res;
    }
}

//分治递归
// 该解法
class Solution2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        helper(root, 0, res);
        return res;
    }
    private void helper(Node root, int level, List<List<Integer>> res) {
        if (root == null) return;
        // 处理当前层状态
        List<Integer> list = res.size() > level ? res.get(level) : new ArrayList();
        list.add(root.val);
        if (res.size() <=level) {
            res.add(list);
        }
        for (Node node : root.children) { //每层带入的状态是【当前节点】和当前节点所处的层数【level】，所处的层数用来同步与list中所在的位置
            helper(node, level + 1, res);
        }
    }
}