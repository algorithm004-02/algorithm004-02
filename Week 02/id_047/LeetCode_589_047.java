import java.util.List;
import java.util.ArrayList;
public class LeetCode_589_047 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.children != null) {
            for (Node aChild :
                    root.children) {
                helper(aChild, result);
            }
        }
    }
}