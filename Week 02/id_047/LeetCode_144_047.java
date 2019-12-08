import java.util.List;
import java.util.ArrayList;
public class LeetCode_144_047 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        helper(root.left, result);
        helper(root.right, result);
    }
}