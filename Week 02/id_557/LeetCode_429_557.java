//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level). 
//
// For example, given a 3-ary tree: 
//
// 
//
// 
//
// 
//
// We should return its level order traversal: 
//
// 
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// Note: 
//
// 
// The depth of the tree is at most 1000. 
// The total number of nodes is at most 5000. 
// 
// Related Topics Tree Breadth-first Search


import javax.xml.soap.Node;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
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
////思路：递归
//class Solution {
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) return Collections.EMPTY_LIST;
//        List<List<Integer>> result = new ArrayList<>();
//        order(result, root, 0);
//        return result;
//    }
//
//    private void order(List<List<Integer>> result, Node node, int level) {
//        if (node == null) return;
//        List<Integer> levelRes = result.size() > level ? result.get(level) : new ArrayList<>();
//        levelRes.add(node.val);
//        if (result.size() <= level) {
//            result.add(levelRes);
//        }
//        for (Node child : node.children
//        ) {
//            order(result, child, level + 1);
//        }
//
//    }
//}

//思路：使用队列进行遍历
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Node node = queue.remove();
                curLevel.add(node.val);
                for (Node child : node.children
                ) {
                    queue.add(child);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
