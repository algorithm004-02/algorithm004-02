//[236]二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

public class LowestCommonAncestorOfABinaryTree {

    private TreeNode common;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        common = null;
        findNode(root, p, q);
        return common;
    }

    private int findNode(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == p.val || root.val == q.val) {
            count++;
        }

        count += findNode(root.left, p, q);
        if (count == 2) {
            common = root;
            return 0;
        }

        count += findNode(root.right, p, q);
        if (count == 2) {
            common = root;
            return 0;
        }

        return count;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        n2.left = new TreeNode(7);
        n2.right = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n5.left = new TreeNode(6);
        n5.right = n2;
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(0);
        n1.right = new TreeNode(8);
        TreeNode root = new TreeNode(3);
        root.left = n5;
        root.right = n1;

        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        TreeNode result1 = solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(result1.val);
        if (result1.val != 3) {
            throw new AssertionError("case1");
        }

        TreeNode result2 = solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(result2.val);
        if (result2.val != 5) {
            throw new AssertionError("case2");
        }
    }
}