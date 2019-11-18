/* 
* 题号: 590
* 题目: N叉树的后序遍历
* 地址: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<> ();
        traversal(root, res);
        return res;
    }
    public void traversal(Node root, List<Integer> res){
        if(root != null){
            if(root.children != null){
                for(Node node : root.children){
                    if(node != null){
                        traversal(node, res);
                    }
                }
            }
            res.add(root.val);
        }
        
    }
}
