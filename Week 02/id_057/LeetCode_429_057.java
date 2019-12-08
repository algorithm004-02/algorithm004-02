package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (60.83%)
 * Likes:    351
 * Dislikes: 36
 * Total Accepted:    49.9K
 * Total Submissions: 81.9K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * We should return its level order traversal:
 * 
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * 
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        levelOrder_queue(root, queue, result);
        return result;
    }



    /**
     * 利用队列实现
     * @param root
     * @param queue
     * @param result
     */
    private void levelOrder_queue(Node root, Queue<Node> queue, List<List<Integer>> result) {
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> subResult = new ArrayList<>();
                result.add(subResult);
                int length = queue.size();
                for (int i = 0; i < length; i++) {
                    Node node = queue.poll();
                    subResult.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
        }

    }

    /**
     * 栈，维护两个栈，一个保存node，一个保存node的level 时间复杂度O(n) 空间复杂度O(n)
     * 
     * @param root
     * @param stack
     * @param result
     */
    private void levelOrder_stack(Node root, Stack<Node> stack, Stack<Integer> levelStack, List<List<Integer>> result) {
        if (root != null) {
            stack.push(root);
            levelStack.push(0);
            
            while (!stack.isEmpty()) {
                if (result.size() <= levelStack.peek()) {
                    result.add(new ArrayList<>());
                }
                Node node = stack.pop();
                result.get(levelStack.peek()).add(node.val);
                int level = levelStack.pop();

                if (node.children != null) {
                    level++;
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                        levelStack.push(level);
                    }
                }
            }
        }

    }

    /**
     * 递归遍历 时间复杂度O(n) 空间复杂度O(n)
     * 
     * @param root
     * @param level
     * @param result
     */
    private void levelOrder_recursion(Node root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            } 
            result.get(level).add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    levelOrder_recursion(child, level + 1, result);
                }
            }
        }
    }


}
// @lc code=end

