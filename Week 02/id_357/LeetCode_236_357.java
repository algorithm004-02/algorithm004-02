import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//TODO: 还没看最佳答案,此外这道题目做的时间比较长，反复修改了，最后反过来看答案，其实思路才慢慢清晰了，分析也清楚了，需要反复追加练习
public class Solution {
    public Map<Integer, Integer> nodeMap = new HashMap();
    public int index = 0;
    Map<Integer, Integer> map = null;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(4);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode1, treeNode2).val);
        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode1, treeNode8).val);
        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode1, treeNode6).val);
        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode3, treeNode7).val);

    }

    public Map<Integer, Integer> inorderTree(TreeNode root) {
        if (root != null) {
            inorderTree(root.left);
            nodeMap.put(root.val, index++);
            inorderTree(root.right);
        }
        return nodeMap;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        if (map == null) {
            map = inorderTree(root);
        }

        if (map.get(p.val) <= map.get(root.val) && map.get(q.val) <= map.get(root.val)) {
            if (p.right == q || p.left == q) {
                return p;
            }

            if (q.right == p || q.left == p) {
                return q;
            }

            return lowestCommonAncestor(root.left, p, q);
        }

        if (map.get(p.val) >= map.get(root.val) && map.get(q.val) >= map.get(root.val)) {
            if (p.right == q || p.left == q) {
                return p;
            }

            if (q.right == p || q.left == p) {
                return q;
            }

            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}

