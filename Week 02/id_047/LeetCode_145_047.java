import java.util.List;
import java.util.ArrayList;

public class LeetCode_145_047 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
}