package datastruct.recur;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 10697 on 2019/10/23.
 */
public class ValidateBinarySearchTree {

    public static void main() {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     *
     *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
        假设一个二叉搜索树具有如下特征：
        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。

     */
    public static void main(String[] args) {
        TreeNode node = null;//new TreeNode();
        //System.out.println(new ValidateBinarySearchTree().isValidBST(node));
    }

//    public boolean isValidBST(TreeNode root) {
//        if(root!=null)
//            helper(root,root.val,0);
//        return flag;
//    }

    private static boolean flag = true;

    public void helper(TreeNode root,int parentRootVal,int type) {

        // 节点的左子树只包含小于当前节点的数。
        // 节点的右子树只包含大于当前节点的数。
        // 所有左子树和右子树自身必须也是二叉搜索树。
        if(root!=null)
        {
            if(root.left!=null) {
                if(root.left.val <= parentRootVal)
                    helper(root.left,root.val,1);
                else
                    flag = false;
            }

            if(flag&&root.right != null) {
                if(root.right.val > parentRootVal)
                    helper(root.right,root.val,2);
                else
                    flag = false;
            }
        }
    }


    /**
     * 1、迭代
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode pre = null;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }

    /**
     * 方法二：递归中序遍历
     *
     */

    TreeNode pre = null;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        // 递归左节点，当左节点小于父节点时候返回false，这里判断取反
        if (!isValidBST2(root.left)) return false;
        // 判断父节点是否为null并且父节点大于当前节点时候，返回false
        if (pre != null && pre.val >= root.val) return false;
        // 把当前节点赋值给pre
        pre = root;
        // 递归右节点
        return isValidBST2(root.right);

    }

    /**
     * 方法三：利用最大值最小值
     *
     */
    public boolean isValidBST3(TreeNode root) {
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isBST(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;
        // 根节点大于最大值，或者小于最小值时候，返回false
        if (root.val >= maxValue || root.val <= minValue) return false;
        // 递归方法，判断左节点小于根节点，并且左节点大于最小值，判断右节点大于根节点，并且右节点小于最大值
        return isBST(root.left,root.val,minValue) && isBST(root.right,maxValue,root.val);
    }




}
