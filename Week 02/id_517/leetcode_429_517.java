/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (63.12%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 17.2K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
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
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        recur(root,list,0);
        return list; 
    }

    public void recur(Node root,List<List<Integer>> list,int size) {
        // terminator 
        // 当节点为空，直接返回
        if (root==null) { 
            return; 
        } 

        // 如果子节点不为空
        // 循环加入传入的childList
        if (size+1 >list.size()) { 
            List<Integer> childList=new ArrayList<>();
            list.add(childList);
        }
        list.get(size).add(root.val);

        for (Node node:root.children) {
            recur( node , list,size+1); 
        }
    }
}
// @lc code=end

