
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _590_narytreepostordertraversal {
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.children = new ArrayList<>();

        Node c1_1 = new Node();
        c1_1.val = 3;

        Node c1_2 = new Node();
        c1_2.val = 2;

        Node c1_3 = new Node();
        c1_3.val = 4;

        root.children.add(c1_1);
        root.children.add(c1_2);
        root.children.add(c1_3);

        c1_1.children = new ArrayList<>();

        Node c2_1 = new Node();
        c2_1.val = 5;

        Node c2_2 = new Node();
        c2_2.val = 6;
        c1_1.children.add(c2_1);
        c1_1.children.add(c2_2);

        Solution1 s1 = new Solution1();
        s1.postorder(root);
        System.out.println(s1.ans);

        Solution2 s2 = new Solution2();
        s2.postorder(root);
        System.out.println(s2.ans);

        Solution3 s3 = new Solution3();
        s3.postorder(root);
        System.out.println(s3.ans);
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

interface ISolution {
    public List<Integer> postorder(Node root);
}

/**
 * 递归法
 */
class Solution1 implements ISolution {

    List<Integer> ans = new ArrayList<>();

    @Override
    public List<Integer> postorder(Node root) {
        _post(root);
        return ans;
    }

    private void _post(Node node) {
        // terminator
        if (node.children == null || node.children.size() == 0) {
            ans.add(node.val);
            return;
        }
        // process logic
        for (Node child : node.children) {
            _post(child);
        }
        ans.add(node.val);
        // drill down
        // revert status
    }
}

/**
 * 迭代法
 */
class Solution2 implements ISolution {

    List<Integer> ans = new ArrayList<>();

    @Override
    public List<Integer> postorder(Node root) {
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        while (!stack.empty()) {
            Node n = stack.peek();
            if (!visited.contains(n) && n.children != null && n.children.size() > 0) {
                for (int i = n.children.size() - 1; i >= 0; i--) {
                    stack.push(n.children.get(i));
                }
                visited.add(n);
            } else {
                n = stack.pop();
                ans.add(n.val);
            }
        }
        return ans;
    }
}

/**
 * 迭代法
 */
class Solution3 implements ISolution {

    List<Integer> ans = new LinkedList<>();

    @Override
    public List<Integer> postorder(Node root) {
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node n = stack.pop();
            ans.add(0, n.val);
            if (n.children != null) {
                for (Node child : n.children) {
                    stack.push(child);
                }
            }
        }
        return ans;
    }
}
