import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_429_047 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(Arrays.asList(root),result);
        return result;
    }
    public void helper(List<Node> levelNodes,List<List<Integer>> result) {
        if (levelNodes == null || levelNodes.size() == 0) {
            return;
        }

        List<Integer> levelVals = new ArrayList<>();
        List<Node> nextlevelNodes = new ArrayList<>();
        for (Node aNode:
                levelNodes) {
            if (aNode == null) {
                continue;
            }
            levelVals.add(aNode.val);
            if (aNode.children != null) {
                nextlevelNodes.addAll(aNode.children);
            }
        }
        result.add(levelVals);
        helper(nextlevelNodes,result);
    }
}