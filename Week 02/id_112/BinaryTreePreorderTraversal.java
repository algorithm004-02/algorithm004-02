package datastruct.tree;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历 前序(In-order):根-左-右
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        rightNode.left = new TreeNode(3);
        root.right = rightNode;
        List<Integer> res = new BinaryTreePreorderTraversal().preorderTraversal2(root);
        res.forEach(x->System.out.print(x+","));
    }

    /**
     * 有两种通用的遍历树的策略：
     *
     *   度优先搜索（DFS）
            在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。
            深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为前序遍历，中序遍历和后序遍历。
         宽度优先搜索（BFS）
            我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
     *
     */


    /**
     * 1、使用递归方式
     */
    public List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) helper(root.left,res);
            if (root.right != null ) helper(root.right,res);
        }

    }

    /**
     * 2、使用stack(栈方式)
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stacks = new Stack<>();
        while(root != null) {
            list.add(root.val);
            if (root.right != null) {
                stacks.push(root.right);
            }
            root = root.left;
            if (root == null && !stacks.isEmpty()) {
                root = stacks.pop();
            }
        }
        return  list;
    }
}
