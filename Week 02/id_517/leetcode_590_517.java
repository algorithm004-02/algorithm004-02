/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.20%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    10.9K
 * Total Submissions: 15.5K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        recur(root,list);
        return list; 
    }

    public void recur(Node root,List<Integer> list) {
        // terminator 
        // 当节点为空，直接返回
        if (root==null) { 
        // process result 
            return; 
        } 
        // process current logic 
        if (root.children!=null) { 
        // process result 
            for (Node node:root.children) {
                recur( node , list); 
            }
        } 
        // drill down 
        // 当前节点操作：添加自己的值
        list.add(root.val);
        // restore current status 
        // 结束操作
       
    }
}
// @lc code=end

