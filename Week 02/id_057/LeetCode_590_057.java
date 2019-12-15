package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (69.02%)
 * Likes:    387
 * Dislikes: 46
 * Total Accepted:    57.2K
 * Total Submissions: 82.8K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * 
 * 
 * Note:
 * 
 * Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
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
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        postorder_stack(root, stack, result);

        return result;
    }



    /**
     * 将node添加到栈中，然后检查栈中元素，
     * 如果有children，则把子节点加入栈中，同时清空root节点的children;
     * 如果没有children，则出栈
     * @param root
     * @param stack
     * @param result
     */
    private void postorder_stack(Node root, Stack<Node> stack, List<Integer> result) {
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.peek();
                if (node.children == null) {
                    result.add(stack.pop().val);
                } else {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                    node.children = null;
                }
            }
        }
    }


    /**
     * 递归 时间复杂度O(n) 空间复杂度O(n)
     * 
     * @param root
     * @param result
     */
    private void postorder_recursion(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null) {
                for (Node child : root.children) {
                    postorder_recursion(child, result);
                }
            }
            result.add(root.val);
        }
    }

    
}
// @lc code=end

