import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_236_047 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> child2Parent = new HashMap<>();
        child2Parent.put(root,null);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!child2Parent.containsKey(p) || !child2Parent.containsKey(q)) {
            TreeNode curr = stack.pop();

            if (curr.left != null) {
                child2Parent.put(curr.left,curr);
                stack.push(curr.left);
            }
            if (curr.right != null) {
                child2Parent.put(curr.right,curr);
                stack.push(curr.right);
            }
        }

        Set<TreeNode> parents1 = new HashSet<>();
        while (p != null) {
            parents1.add(p);
            p = child2Parent.get(p);
        }

        while (!parents1.contains(q)) {
            q = child2Parent.get(q);
        }
        return q;
    }
}