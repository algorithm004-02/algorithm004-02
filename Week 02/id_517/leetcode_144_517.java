/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (62.10%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    46.5K
 * Total Submissions: 74.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        recur(root,list);
        return list; 
    }

    public void recur(TreeNode root,List<Integer> list) {
        // terminator 
        // 当节点为空，直接返回
        if (root==null) { 
        // process result 
            return; 
        } 
        // process current logic 

        // drill down 
        // 当前节点操作：先添加自己的值，在遍历左子树，再遍历右子树
        list.add(root.val);
        recur( root.left , list); 
        recur( root.right , list); 
        // restore current status 
        // 结束操作
       
    }
}
// @lc code=end

