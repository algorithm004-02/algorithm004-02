/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (70.28%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 17.9K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
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
    public List<Integer> preorder(Node root) {
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
        // 当前节点操作：添加自己的值
        list.add(root.val);
        // process current logic 
        if (root.children!=null) { 
        // process result 
            for (Node node:root.children) {
                recur( node , list); 
            }
        } 
        // drill down 

        // restore current status 
        // 结束操作
       
    }
}
// @lc code=end

