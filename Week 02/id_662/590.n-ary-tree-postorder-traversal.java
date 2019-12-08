/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 */

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        return postorderHelper(root,list);
    }

    public List<Integer> postorderHelper(Node root,List<Integer> list) {
        List<Node> children = root.children;
        for(Node node:children){
            postorderHelper(node,list);
        }
        list.add(root.val);
        return list;
    }
}