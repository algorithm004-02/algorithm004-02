//[589]N叉树的前序遍历
//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                list.addAll(preorder(child));
            }
        }
        return list;
    }

    private static class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node n3 = new Node(3, Arrays.asList(
                new Node(5, null),
                new Node(6, null)));
        Node root = new Node(1, Arrays.asList(n3,
                new Node(2, null),
                new Node(4, null)));
        NAryTreePreorderTraversal solution = new NAryTreePreorderTraversal();
        List<Integer> result = solution.preorder(root);
        System.out.println(result);
        if (!Arrays.equals(new int[]{1, 3, 5, 6, 2, 4},
                result.stream().mapToInt(Integer::intValue).toArray())) {
            throw new AssertionError("case1");
        }
    }
}