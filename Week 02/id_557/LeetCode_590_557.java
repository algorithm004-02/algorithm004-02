
//Given an n-ary tree, return the postorder traversal of its nodes' values.
//
// For example, given a 3-ary tree: 
//
// 
//
// 
//
// 
//
// Return its postorder traversal as: [5,6,3,2,4,1]. 
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
//preorder的顺序：root,left,right
//postorder的顺序：left,right,root
//preorder reverse的顺序：right,left,root
//所以将preorder的顺序稍作调整为root，right，left然后reverse就可以得到postorder的顺序
//可以使用双栈，也可以使用单栈

//使用单栈
//class Solution {
//    public List<Integer> postorder(Node root) {
//
//        if (root == null) return Collections.EMPTY_LIST;
//        Stack<Node> stack = new Stack<>();
//        List<Integer> result = new ArrayList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            result.add(root.val);
//            for (Node node : root.children
//            ) {
//                stack.push(node);
//            }
//        }
//        Collections.reverse(result);
//        return result;
//    }
//}

//使用双栈
//class Solution {
//    public List<Integer> postorder(Node root) {
//
//        if (root == null) return Collections.EMPTY_LIST;
//        Stack<Node> stack = new Stack<>();
//        Stack<Node> stack2 = new Stack<>();
//        List<Integer> result = new ArrayList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            stack2.push(root);
//            for (Node node : root.children
//            ) {
//                stack.push(node);
//            }
//        }
//        while(!stack2.isEmpty()){
//            result.add(stack2.pop().val);
//        }
//        return result;
//    }
//}

//思路：使用递归
class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        for (Node node : root.children) {
            result.addAll(postorder(node));
        }
        result.add(root.val);
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
