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
    /**
        429. N叉树的层序遍历
        Queue + 迭代
    */
     public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
         while (!queue.isEmpty()) {
             int count = queue.size();
             List<Integer> list = new ArrayList<>();
             while (count-- > 0) {
                 Node cur = queue.poll();
                 if (cur == null) {
                     return res;
                 }
                 list.add(cur.val);
                 for (Node node : cur.children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
             }
             res.add(list);
         }
        return res;
    }
    
    
    /**
        429. N叉树的层序遍历
        递归
    */
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) return res;
//         helper(root, 0, res);
//         return res;
//     }
    
//     private void helper(Node root, int depth, 
//                         List<List<Integer>> res) {
//         if (root == null) return;
//         //加新的一层
//         if (depth+1 > res.size()) {
//             res.add(new ArrayList<>());
//         }
//         res.get(depth).add(root.val);
//         for (Node node : root.children) {
//             if (node != null) {
//                 helper(node, depth+1, res);
//             }
//         }
//     }
}