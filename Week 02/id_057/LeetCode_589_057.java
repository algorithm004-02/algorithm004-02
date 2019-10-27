package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (69.02%)
 * Likes:    318
 * Dislikes: 44
 * Total Accepted:    64.1K
 * Total Submissions: 92.7K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * 
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        preorder_stack(root, stack, result);
        return result;
    }

    /**
     * 出栈的时候，把子元素从右向左加入栈中
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param stack
     * @param result
     */
    private void preorder_stack(Node root, Stack<Node> stack, List<Integer> result) {
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
        }
    }

    /**
     * 递归，前序遍历：根，左，右 
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param result
     */
    private void preorder_recursion(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    preorder_recursion(child, result);
                }
            }
        }
    }


}
// @lc code=end

