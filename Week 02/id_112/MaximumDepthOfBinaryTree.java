package datastruct.recur;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 */
public class MaximumDepthOfBinaryTree {


    /**
     * 方法一、递归，使用DFS方式搜索最大深度
     * 时间复杂度：
     *  O(N)
     *  空间复杂度：
     *  最差O(N),最好O(log(N))
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    /**
     * 方法二：迭代
     * 我们的想法是使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
     * 所以我们从包含根结点且相应深度为 1 的栈开始。
     * 然后我们继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
     *
     * 时间复杂度为O(N)
     * 空间复杂度为O(N)
     */

    public int maxDepth1(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        if(root != null) stack.add(new Pair(root,1));
        int depth = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode,Integer> current = stack.poll();
            int current_depth = current.getValue();
            if(root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }



}
