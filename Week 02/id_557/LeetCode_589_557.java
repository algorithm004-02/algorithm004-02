//Given an n-ary tree, return the preorder traversal of its nodes' values. 
//
// For example, given a 3-ary tree: 
//
// 
//
// 
//
// 
//
// Return its preorder traversal as: [1,3,5,6,2,4]. 
//
// 
//
// Note: 
//
// Recursive solution is trivial, could you do it iteratively? 
// Related Topics Tree


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
//思路：迭代遍历
//class Solution {
//    public List<Integer> preorder(Node root) {
//        if (root == null) return Collections.EMPTY_LIST;
//        List<Integer> result = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            result.add(root.val);
//            for (int i = root.children.size() - 1; i >= 0; i--
//            ) {
//                stack.push(root.children.get(i));
//            }
//        }
//        return result;
//    }
//}

//思路：递归
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        for (Node node : root.children
        ) {
            result.addAll(preorder(node));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

