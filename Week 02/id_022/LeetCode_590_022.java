//[590]N叉树的后序遍历
//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        if (root.children != null) {
            for (Node child : root.children) {
                list.addAll(postorder(child));
            }
        }
        list.add(root.val);
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
        NAryTreePostorderTraversal solution = new NAryTreePostorderTraversal();
        List<Integer> result = solution.postorder(root);
        System.out.println(result);
        if (!Arrays.equals(new int[] {5, 6, 3, 2, 4, 1},
                result.stream().mapToInt(Integer::intValue).toArray())) {
            throw new AssertionError("case1");
        }

    }
}