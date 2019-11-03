/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.42%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    70.2K
 * Total Submissions: 102.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        recur(root,list);
        return list; 
    }

    public void recur(TreeNode root,List<Integer> list) {
        // terminator 
        // 当节点为空，直接返回
        if (root==null) { 
        // process result 
            return ; 
        } 
        // process current logic 

        // drill down 
        // 当前节点操作：先遍历左子树，在添加自己的值，再遍历右子树
        recur( root.left , list); 
        list.add(root.val);
        recur( root.right , list); 

        // restore current status 
        // 结束操作
       
    }
}
// @lc code=end

