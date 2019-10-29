import java.util.List;
import java.util.ArrayList;
public class LeetCode_590_047 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node aChild :
                    root.children) {
                helper(aChild, result);
            }
        }
        result.add(root.val);
    }
}