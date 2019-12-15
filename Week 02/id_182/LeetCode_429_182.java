/* 
* 题号: 429
* 题目: N叉树的层序遍历
* 地址: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
*/

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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        order(root, res, 0);
        return res;
    }
    public void order(Node root, List<List<Integer>> res, int level){
        if(1 + level > res.size()){
                res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if(root != null){
            if(root.children != null){
                for(Node node : root.children){
                    if(node != null){
                        order(node, res, level + 1);
                    }
                }
            }
        }
    }
}
